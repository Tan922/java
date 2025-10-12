package model.sort;

public enum SortingStrategy {
    BubbleSort {
        @Override
        public void sort(int[] array) {
            System.out.println("Sorting using Bubble Sort");
        }
    },
    MergeSort {
        @Override
        public void sort(int[] array) {
            System.out.println("Sorting using Merge Sort");
        }
    },
    QuickSort {
        @Override
        public void sort(int[] array) {
            System.out.println("Sorting using Quick Sort");
        }
    };
    public abstract void sort(int[] array);
}
