package material;

import java.util.Random;

class procress {
    int[] patternNumber = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

    public int[] shuffleNumber() {
        int[] tmp = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        shuffleArray(patternNumber);
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = patternNumber[i];
        }
        patternNumber = tmp;
        return tmp;
    }

    // Shuffle
    private void shuffleArray(int[] a) {
        int n = a.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }
    }

    private void swap(int[] a, int i, int change) {
        int helper = a[i];
        a[i] = a[change];
        a[change] = helper;
    }
}
