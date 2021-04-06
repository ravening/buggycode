package src.Trees;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeDeserialize {
    private final int MIN_VALUE = Integer.MIN_VALUE;

    TreeNode<Integer> root;

    SerializeDeserialize() {
        root = null;
    }

    public static void main(String[] args) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            SerializeDeserialize serializeDeserialize = new SerializeDeserialize();

            serializeDeserialize.serialize(serializeDeserialize.root, objectOutputStream);
            objectOutputStream.close();

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            serializeDeserialize.root = serializeDeserialize.deserialize(objectInputStream);
        } catch (Exception ignored) {}
    }

    private void serialize(TreeNode<Integer> root, ObjectOutputStream stream) throws IOException {
        if (root == null) {
            stream.writeInt(MIN_VALUE);
            return;
        }

        stream.writeInt(root.getData());
        serialize(root.getLeft(), stream);
        serialize(root.getRight(), stream);
    }

    private TreeNode<Integer> deserialize(ObjectInputStream stream) throws IOException {
        int val = stream.readInt();
        if (val == MIN_VALUE) {
            return null;
        }

        TreeNode<Integer> node = new TreeNode<>(val);
        node.setLeft(deserialize(stream));
        node.setRight(deserialize(stream));

        return node;
    }
}
