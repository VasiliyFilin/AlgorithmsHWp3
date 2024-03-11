package skypro.algorithmshwp3;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList{
    private Integer[] ints;
    private int size;

    public IntegerListImpl() {
        ints = new Integer[5];
    }
    public IntegerListImpl(int size) {
        ints = new Integer[size];
    }

    @Override
    public Integer add(Integer item) {
        checkItem(item);
        checkSize(size);
        this.ints[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkIndex(index);
        checkItem(item);
        if (index == size) {
            this.ints[size++] = item;
            return item;
        }
        System.arraycopy(ints, index, ints, index + 1, size - index);
        this.ints[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkIndex(index);
        checkItem(item);
        this.ints[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        checkItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ItemNotFoundException();
        }
        System.arraycopy(ints, index + 1, ints, index, size - 1 - index);
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        checkIndex(index);
        Integer item = ints[index];
        System.arraycopy(ints, index + 1, ints, index, size - 1 - index);
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] ints = toArray();
        quickSort(ints, ints[0], ints.length - 1);
        return binarySearch(ints, item);
    }

    @Override
    public int indexOf(Integer item) {
        checkItem(item);
        for (int i = 0; i < size; i++) {
            if (ints[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkItem(item);
        int index = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (ints[i].equals(item)) {
                index = i;
                return index;
            } else {
                index = -1;
            }
        }
        return index;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);
        Integer item = ints[index];
        checkItem(item);
        return item;
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        Arrays.copyOf(ints, size);
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(ints, size);
    }

    private void checkItem(Integer item) {
        if (item == null) {
            throw new NullArgumentException();
        }
    }
    private void checkSize(int size) {
        if (size == ints.length) {
            ints = grow(ints);
        }
    }
    private void checkIndex (int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundException();
        }
    }

    private void sort (Integer[] ints) {
        for (int i = 1; i < ints.length; i++) {
            int temp = ints[i];
            int j = i;
            while (j > 0 && ints[j - 1] >= temp) {
                ints[j] = ints[j - 1];
                j--;
            }
            ints[j] = temp;
        }
    }

    private boolean binarySearch(Integer[] ints, Integer item) {
        int min = 0;
        int max = ints.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == ints[mid]) {
                return true;
            }

            if (item < ints[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private Integer[] grow(Integer[] ints) {
        Integer[] destArray = new Integer[ints.length + size / 2];
        System.arraycopy(ints, 0, destArray, 0, ints.length);
        return destArray;
    }
    public void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private void swapElements(Integer[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
