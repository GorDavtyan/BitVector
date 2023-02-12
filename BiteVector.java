import java.util.Scanner;

public class BiteVector {
    public static void main(String[] args) {

        BiteVector bitobj = new BiteVector();
        bitobj.functions();
        char input_set_reset;
        char set_reset_off;
        do {
            System.out.println("Do you want to check the set or reset please import s/r");
            input_set_reset = bitobj.input.next().charAt(0);

            if (input_set_reset == 's') {
                bitobj.set(bitobj.bit);
            } else if (input_set_reset == 'r') {
                bitobj.reset(bitobj.bit);
            }
            System.out.println("Do you want to go out pleas import  y/n");
            set_reset_off = bitobj.input.next().charAt(0);
            if (set_reset_off == 'y') {
                break;
            } else {
                System.out.println("Please import new bit");
                bitobj.bit = bitobj.input();
                bitobj.bit_size_negative(bitobj.bit);
                bitobj.pos = bitobj.index(bitobj.bit);
                if (bitobj.bit > bitobj.bit_size) {
                    bitobj.big_bit();
                }
                continue;
            }
        } while (input_set_reset == 's' || input_set_reset == 'r');
    }

    Scanner input = new Scanner(System.in);
    private int bit_size;
    private int arr[];
    private int bit;
    private int size;
    private int pos;

    public void functions() {
        System.out.println("Please import bit size number");
        bit_size = input();
        bit_size_negative(bit_size);
        size = bit_length(bit_size);
        arr = array(size);
        System.out.println("Please enter bit number");
        bit = input();
        bit_size_negative(bit);
        pos = index(bit);
    }


    public int input() {
        return input.nextInt();
    }

    public void big_bit() {
        size = bit_length(bit);
        arr = resizearray(bit);
        pos = index(bit);
    }

    public void bit_size_negative(int bit_neg) {
        while (bit_neg < 0) {
            System.out.println("The bit size cannot be negative, please enter a positive number");
            bit_neg = input();
        }
    }

    public int bit_length(int bit_size) {
        int len;
        if (bit_size % 32 == 0) {
            len = bit_size / 32;
        } else {
            len = bit_size / 32 + 1;
        }
        return len;
    }

    public int[] array(int s) {
        int[] tmp = new int[s];
        return tmp;
    }

    public int index(int bit) {
        int position;
        if (bit % 32 == 0) {
            position = size - bit / 32 - 1;
        } else {
            position = size - 1 - bit / 32;
        }
        return position;
    }

    public int[] resizearray(int bit) {
        int len = size - arr.length;
        int sym[] = new int[len];
        int[] resizearray = new int[size];
        int i = 0;
        while (i < sym.length) {
            resizearray[i] = sym[i];
            ++i;
        }
        i = 0;
        int j = sym.length;
        while (j < resizearray.length) {
            resizearray[j] = arr[i];
            ++i;
            ++j;
        }
        return resizearray;
    }


    public void toBinary() {
        System.out.println("The binary : ");
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 31; j >= 0; j--) {
                System.out.print(arr[i] >>> j & 1);
            }
            System.out.println();
        }
    }


    public void set(int bit) {
        arr[pos] |= 1 << (bit % 32);
        System.out.println("The bit set : ");
        toBinary();
    }

    public void reset(int bit) {

        arr[pos] &= ~(1 << (bit % 32));
        System.out.println("The bit reset =  ");
        toBinary();
    }
}




