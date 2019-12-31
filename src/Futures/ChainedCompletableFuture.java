package Futures;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * ChainedCompletableFuture
 */
public class ChainedCompletableFuture {

    public static void main(String[] args) {
        ChainedCompletableFuture chain = new ChainedCompletableFuture();
        chain.asyncExample();
    }

    public void asyncExample() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        // simulate the list of user ids
        Supplier<List<Long>> supplyIds = () -> {
            System.out.println("Getting the user ids from thread " + Thread.currentThread().getName());
            return Arrays.asList(1L, 2L, 3L, 4L, 5L);
        };

        // simulate fetching users from database
        Function<List<Long>, List<String>> fetchUsers = ids -> {
            System.out.println("fetching the users from the database using thread " + Thread.currentThread().getName());
            return ids.stream().map(x -> String.valueOf(x)).collect(Collectors.toList());
        };

        // simulate fetching users from database in async
        Function<List<Long>, CompletableFuture<List<String>>> fetchUsersAsync = ids -> {
            Supplier<List<String>> uSupplier = () -> 
                ids.stream().map(x -> String.valueOf(x)).collect(Collectors.toList());

            return CompletableFuture.supplyAsync(uSupplier);
        };

        // simulate returning the email address
        Function<List<Long>, CompletableFuture<List<String>>> fetchEmailAsync = ids -> {
            Supplier<List<String>> supplier = () ->
                ids.stream().parallel().map(x -> 
                    {String s = String.valueOf(x) + "@gmail.com"; return s;}).collect(Collectors.toList());
            
            return CompletableFuture.supplyAsync(supplier);
        };

        // simluate displaying the users
        Consumer<List<String>> displayer = users -> {
            System.out.println("Running in thread " + Thread.currentThread().getName());
            users.forEach(System.out::println);
        };

        CompletableFuture<List<Long>> completableFuture = CompletableFuture.supplyAsync(supplyIds, service);
        completableFuture.thenComposeAsync(fetchUsersAsync, service)
                        .thenAcceptAsync(displayer, service);
        
        CompletableFuture<List<String>> userFuture = completableFuture.thenCompose(fetchUsersAsync);
        CompletableFuture<List<String>> emailFuture = completableFuture.thenComposeAsync(fetchEmailAsync);

        System.out.println("Running then accept both");
        userFuture.thenAcceptBothAsync(emailFuture, 
                                (users, emails) -> {
                                    System.out.println(users.size() + " - " + emails.size());
                                });

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public CompletableFuture<Integer> getBirthYear() {
        return CompletableFuture.supplyAsync(() -> {
            return 1987;
        });
    }

    public CompletableFuture<Integer> getCurrentYear() {
        return CompletableFuture.supplyAsync(() -> {
            return Calendar.getInstance().get(Calendar.YEAR);
        });
    }

    public void independantCompletableFutures() {
        // Two completable futures which are independant of each other
        try {
            ChainedCompletableFuture chains = new ChainedCompletableFuture();
            CompletableFuture<Integer> age = chains.getCurrentYear()
                .thenCombineAsync(chains.getBirthYear(), (currentYear, birthYear) -> {
                    return currentYear - birthYear;
                });

            System.out.println("My age is " + age.get());
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

   

    public void dependantCompletableFutures() {
        // Two chained completable futures which are dependant on each other
        try {
            ChainedCompletableFuture chains = new ChainedCompletableFuture();

            // Nested completable future which is messy
            // CompletableFuture<CompletableFuture<String>> result = first.thenApplyAsync(param -> second(param));

            // thencompose acts as flatmap
            CompletableFuture<String> composeFuture = chains.getUserInfo().thenCompose(param -> chains.getUserRatings(param));

            System.out.println(composeFuture.get());
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public CompletableFuture<String> getUserInfo() {
        return CompletableFuture.supplyAsync(() -> {
            return "First completable future";
        });
    }

    public CompletableFuture<String> getUserRatings(String param) {
        return CompletableFuture.supplyAsync(() -> {
            return param + " Second completable future";
        });
    }

    public void simpleCompletableFuture() {
        try {
            Supplier<List<Long>> supplier = () -> List.of(1L, 2L, 3L, 4L, 5L);
            Function<List<Long>, String> function = ids -> {
            StringBuilder sBuilder = new StringBuilder();
                for (Long l : ids) {
                    sBuilder.append("Id is " + l);
                }

                return sBuilder.toString();
            };

            CompletableFuture<String> cf = CompletableFuture.supplyAsync(supplier)
                                                                    .thenApplyAsync(function);
            String result = cf.get();
            System.out.println("Result is " + result);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}