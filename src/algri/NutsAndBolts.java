package algri;

class Nut extends NutsAndBolts {
    public int size;

    Nut(int size) {
        this.size = size;
    }
}

class Bolt extends NutsAndBolts {
    public int size;

    Bolt(int size) {
        this.size = size;
    }
}


public class NutsAndBolts {
    public void quickSort(Nut[] a, Bolt[] b, int left, int right) {
        if (left >= right) return;
        int nutsSplit = partition(a, b, 1, left, right, left);
        int boltsSplis = partition(a, b, 0, left, right, nutsSplit);
        quickSort(a, b, left, boltsSplis - 1);
        quickSort(a, b, boltsSplis + 1, right);
    }

    public static void main(String[] args) {
        Nut a[] = {new Nut(1), new Nut(3), new Nut(2), new Nut(0), new Nut(4)};
        Bolt b[] = {new Bolt(3), new Bolt(2), new Bolt(4), new Bolt(1), new Bolt(0)};
        NutsAndBolts tt=new NutsAndBolts();
        tt.quickSort(a,b,0,a.length);
        System.out.println(1);
    }

    public int partition(Nut[] a, Bolt[] b, int type, int left, int right, int index) {
        if (type == 1) {
            Bolt pivot = b[index];
            while (left < right) {
                while (left < right && a[left].size < pivot.size) left++;
                while (right > left && a[right].size > pivot.size) right--;
                if (left < right)
                    a[left].size = a[right].size + a[left].size - (a[right].size = a[left].size);
            }
            return left;
        } else {
            Nut pivot = a[index];
            while (left < right) {
                while (left < right && b[left].size < pivot.size) left++;
                while (right > left && b[right].size > pivot.size) right--;
                if (left < right)
                    b[left].size = b[right].size + b[left].size - (b[right].size = b[left].size);
            }
        }
        return right;

    }


}
