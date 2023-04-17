package edu.slcc.asdv.bl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author A. V. Markou
 */
public class Matrices implements Matrix
{

  
    @Override
    public ArrayList<ArrayList<BigInteger>> addParallel(ArrayList<ArrayList<BigInteger>> A, ArrayList<ArrayList<BigInteger>> B)
    {
        RecursiveTask<ArrayList<ArrayList<BigInteger>>> rt
                = new Matrices.MatricesAddition(0, A.size() - 1, A, B);
        ForkJoinPool pool = new ForkJoinPool();
        ArrayList<ArrayList<BigInteger>> result = pool.invoke(rt);
        return result;
    }

    @Override
    public ArrayList<ArrayList<BigInteger>> multiplyParallel(ArrayList<ArrayList<BigInteger>> A, ArrayList<ArrayList<BigInteger>> B)
    {
        RecursiveTask<ArrayList<ArrayList<BigInteger>>> rt
                = new Matrices.MatricesMultiplication(0, A.size() - 1, A, B);
        ForkJoinPool pool = new ForkJoinPool();
        ArrayList<ArrayList<BigInteger>> result = pool.invoke(rt);
        return result;
    }






    static class MatricesAddition extends RecursiveTask<ArrayList<ArrayList<BigInteger>>>
    {

        ArrayList<ArrayList<BigInteger>> A;
        ArrayList<ArrayList<BigInteger>> B;
        ArrayList<ArrayList<BigInteger>> AplusB;
        final int HOW_MANY_ROWS_IN_PARALLEL = 100;//threshold
        int startIndex;
        int endIndex;

        public MatricesAddition(int startIndex, int endIndex,
                ArrayList<ArrayList<BigInteger>> A,
                ArrayList<ArrayList<BigInteger>> B)
        {
            this.startIndex = startIndex;//start at this row of the matrix
            this.endIndex = endIndex;//end at this row of the matrix
            this.A = A;
            this.B = B;
            AplusB = new ArrayList<ArrayList<BigInteger>>();

        }

        @Override
        protected ArrayList<ArrayList<BigInteger>> compute()
        {
            //>>This is the addition of matrices in the IF.
            //That is, HOW_MANY_ROWS_IN_PARALLEL from matrix A and HOW_MANY_ROWS_IN_PARALLEL from matrix B
            if (this.endIndex - this.startIndex < HOW_MANY_ROWS_IN_PARALLEL)
            {
                ArrayList<ArrayList<BigInteger>> resultC = new ArrayList<ArrayList<BigInteger>>();
                for (int i = this.startIndex; i <= this.endIndex; ++i)
                {
                    //>create a new row to add it to the resulting matrix resultC
                    ArrayList<BigInteger> rowAplusB = new ArrayList<BigInteger>();

                    for (int j = 0; j < A.get(0).size(); j++)

                    //>get the Ith row from A and the Ith row from B and
                    //and add all the Jth entries from each row
                    {
                        BigInteger x = A.get(i).get(j);
                        BigInteger y = B.get(i).get(j);
                        BigInteger z = x.add(y);
                        
                        rowAplusB.add(z);
                    }
                    resultC.add(rowAplusB);
                }
                return resultC;
            }
            else
            {      //>> keep on FORKING the matrix until the 
                //side of the matric is equal or less to HOW_MANY_ROWS_IN_PARALLEL

                int mid = (this.endIndex + this.startIndex) / 2;
                RecursiveTask<ArrayList<ArrayList<BigInteger>>> firstHalf
                        = new MatricesAddition(this.startIndex, mid, A, B);

                RecursiveTask<ArrayList<ArrayList<BigInteger>>> secondHalf
                        = new MatricesAddition(mid + 1, this.endIndex, A, B);

                firstHalf.fork();//this line will  invoke method compute
                secondHalf.fork();///this line will  invoke method compute

                //>> join what the FORKs returned from the IFs 
                AplusB.addAll(firstHalf.join());
                AplusB.addAll(secondHalf.join());

                return AplusB;
            }
        }

    }

    /**
     * Multiples two lists one 1-t01 correspondence, that is the 1st element of
     * the first list is multiplied with 1st elements of the second list and so
     * on
     *
     * @param list1
     * @param list2
     * @return the multiplied results
     */
    public static ArrayList<BigInteger> multiplyLists(ArrayList<BigInteger> list1, ArrayList<BigInteger> list2)
    {
        ArrayList<BigInteger> resultsOfMultiplications = new ArrayList<BigInteger>();
        for (int bi = 0; bi < list1.size();
                ++bi)
        {
            resultsOfMultiplications.add(list1.get(bi).multiply(list2.get(bi)));
        }
        return resultsOfMultiplications;
    }

    public static ArrayList<ArrayList<BigInteger>> columnMajorOrderReversal(ArrayList<ArrayList<BigInteger>> b)
    {
        ArrayList<ArrayList<BigInteger>> tranformed = new ArrayList<ArrayList<BigInteger>>();
        for (int column = 0;
                column < b.get(0).size();
                ++column)
        {
            ArrayList<BigInteger> rowTrandormedToColmn = new ArrayList<BigInteger>();
            for (int row = 0;
                    row < b.size();
                    ++row)
            {
                BigInteger bd = b.get(row).get(column);
                rowTrandormedToColmn.add(bd);
            }
            tranformed.add(rowTrandormedToColmn);
        }

        return tranformed;
    }

    /**
     * Adds a list of Big Decimals and returns the result of the addition.
     *
     * @param list - list of BigDecimal type
     * @return the sum of the list
     */
    public static BigInteger add(ArrayList<BigInteger> list)
    {
        BigInteger bd = BigInteger.ZERO;
        for (int bi = 0; bi < list.size();
                bi++)
        {
            bd = bd.add(list.get(bi));
        }
        return bd;
    }

    static class MatricesMultiplication extends RecursiveTask<ArrayList<ArrayList<BigInteger>>>
    {

        ArrayList<ArrayList<BigInteger>> A;
        ArrayList<ArrayList<BigInteger>> B;
        ArrayList<ArrayList<BigInteger>> AxB;
        final int HOW_MANY_ROWS_IN_PARALLEL = 3;//threshold
        int startIndex;
        int endIndex;

        public MatricesMultiplication(int startIndex, int endIndex,
                ArrayList<ArrayList<BigInteger>> A,
                ArrayList<ArrayList<BigInteger>> B)
        {
            this.startIndex = startIndex;//start at this row of the matrix
            this.endIndex = endIndex;//end at this row of the matrix
            this.A = A;
            this.B = B;
            AxB = new ArrayList<ArrayList<BigInteger>>();

        }

        /**
         * matrix 1, 2, 3 4, 5, 6
         *
         * will be transformed to 1, 4 2, 5 3, 6
         *
         * @param list
         * @return
         */
        @Override
        protected ArrayList<ArrayList<BigInteger>> compute()
        {
            //>>This is the addition of matrices in the IF.
            //That is, HOW_MANY_ROWS_IN_PARALLEL from matrix A and HOW_MANY_ROWS_IN_PARALLEL from matrix B
            if (this.endIndex - this.startIndex < HOW_MANY_ROWS_IN_PARALLEL)
            {
                ArrayList<ArrayList<BigInteger>> resultC = new ArrayList<ArrayList<BigInteger>>();
                ArrayList<ArrayList<BigInteger>> bTransformed = columnMajorOrderReversal(B);

                for (int biA = this.startIndex;
                        biA <= this.endIndex;
                        ++biA)
                {
                    ArrayList<BigInteger> rowA = A.get(biA);
                    ArrayList<BigInteger> rowAxB = new ArrayList<BigInteger>();
                    ArrayList<BigInteger> rowCalculation = new ArrayList<BigInteger>();
                    for (int biB = 0;
                            biB < bTransformed.size();
                            ++biB)
                    {
                        ArrayList<BigInteger> rowB = bTransformed.get(biB);

                        ArrayList<BigInteger> productsOfRow = multiplyLists(rowA, rowB);
                        BigInteger sumOfRow = add(productsOfRow);
                        rowCalculation.add(sumOfRow);

                    }
                    resultC.add(rowCalculation);

                }
                return resultC;
            }
            else
            {      //>> keep on FORKING the matrix until the 
                //side of the matric is equal or less to HOW_MANY_ROWS_IN_PARALLEL

                int mid = (this.startIndex + this.endIndex) / 2;
                RecursiveTask<ArrayList<ArrayList<BigInteger>>> firstHalf
                        = new MatricesMultiplication(this.startIndex, mid, A, B);

                RecursiveTask<ArrayList<ArrayList<BigInteger>>> secondHalf
                        = new MatricesMultiplication(mid + 1, this.endIndex, A, B);

                firstHalf.fork();//this line will  invoke method compute
                secondHalf.fork();///this line will  invoke method compute

                //>> join what the FORKs returned from the IFs 
                AxB.addAll(firstHalf.join());
                AxB.addAll(secondHalf.join());

                return AxB;
            }
        }

    }

}
