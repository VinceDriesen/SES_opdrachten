package be.kuleuven.candycrush;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckNeighboursInGrid {

    public static void main(String[] args) {
        ArrayList<Integer> speelVeld = new ArrayList<Integer>();
        speelVeld.add(0);speelVeld.add(0);speelVeld.add(1);speelVeld.add(0);speelVeld.add(1);
        speelVeld.add(1);speelVeld.add(2);speelVeld.add(1);speelVeld.add(1);speelVeld.add(0);
        speelVeld.add(0);speelVeld.add(2);speelVeld.add(1);speelVeld.add(2);speelVeld.add(0);
        speelVeld.add(1);speelVeld.add(1);speelVeld.add(0);speelVeld.add(1);speelVeld.add(1);
        speelVeld.add(2);speelVeld.add(1);speelVeld.add(0);speelVeld.add(0);speelVeld.add(0);

        for (int test = 0; test < 25; test++) {
            System.out.println(getSameNeighboursIds(speelVeld, 5, 5, test));
        }


    }

    /**
     * This method takes a 1D Iterable and an element in the array and gives back an iterable containing the indexes of all neighbours with the same value as the specified element
     *@return - Returns a 1D Iterable of ints, the Integers represent the indexes of all neighbours with the same value as the specified element on index 'indexToCheck'.
     *@param grid - This is a 1D Iterable containing all elements of the grid. The elements are integers.
     *@param width - Specifies the width of the grid.
     *@param height - Specifies the height of the grid (extra for checking if 1D grid is complete given the specified width)
     *@param indexToCheck - Specifies the index of the element which neighbours that need to be checked
     */
    public static Iterable<Integer> getSameNeighboursIds(Iterable<Integer> grid,int width, int height, int indexToCheck) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> neighbors = new ArrayList<>();

        for (Integer integer : grid) {
            list.add(integer);
        }
        int numberToCheck = list.get(indexToCheck);
        int numberPosVeritcal = indexToCheck / width;
        int numberPosHorizontal = indexToCheck - (numberPosVeritcal * height);

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if(i == 0 && j == 0) { continue; }
                int indexNumber =(numberPosVeritcal + j)*width + (numberPosHorizontal + i);
                if (numberPosHorizontal + i < 0 || numberPosHorizontal + i >= width || numberPosVeritcal + j < 0 || numberPosVeritcal + j >= height) {continue;}
                if (list.get((numberPosVeritcal + j)*width + (numberPosHorizontal + i)) == numberToCheck) {
                    neighbors.add(indexNumber);
                }
            }
        }
        Collections.sort(neighbors);
        return neighbors;
    }
}
