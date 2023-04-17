/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.termproject1_converters.MyString2;
import edu.slcc.asdv.termproject1_converters.MyString3;
import edu.slcc.asdv.bl.Matrices;
import edu.slcc.asdv.bl.Matrix;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 *  @author A. V. Markou
 */
@Named(value = "matrixOperations")
@ViewScoped
public class MatrixOperations implements Serializable
{

    @Inject
    MatrixBeanA matrixA;
    @Inject
    MatrixBeanB matrixB;

    @Inject
    MatrixBeanC matrixC;

    public String add()
    {
        ArrayList<ArrayList<BigInteger>> A = convertMyString2ToBigInteger(this.matrixA.getMatrix());
        ArrayList<ArrayList<BigInteger>> B = convertMyString3ToBigInteger(this.matrixB.getMatrix());

        Matrix m = new Matrices();
        ArrayList<ArrayList<BigInteger>> bigIntC = m.addParallel(A, B);

        ArrayList<ArrayList<String>> stringsC = this.convertBigIntegerToString(bigIntC);
        this.matrixC.setMatrix(stringsC);
        return "";
    }
  private void testPrint( ArrayList<ArrayList<BigInteger>>  m )
  {
      for ( ArrayList<BigInteger> r : m)
      {
          System.out.println(r);
      }
  }
    public String multiply()
    {
        ArrayList<ArrayList<BigInteger>> A = convertMyString2ToBigInteger(this.matrixA.getMatrix());
        ArrayList<ArrayList<BigInteger>> B = convertMyString3ToBigInteger(this.matrixB.getMatrix());

        Matrix m = new Matrices();
        ArrayList<ArrayList<BigInteger>> bigIntC = m.multiplyParallel(A, B);

        ArrayList<ArrayList<String>> stringsC = this.convertBigIntegerToString(bigIntC);
        this.matrixC.setMatrix(stringsC);
        return "";
    }

    public ArrayList<ArrayList<BigInteger>> convertMyString2ToBigInteger(ArrayList<ArrayList<MyString2>> matrix)
    {
        ArrayList<ArrayList<BigInteger>> bigIntMatrix = new ArrayList<ArrayList<BigInteger>>();

        for (ArrayList<MyString2> row : this.matrixA.getMatrix())
        {
            ArrayList<BigInteger> bigInteRow = new ArrayList<BigInteger>();
            for (MyString2 s : row)
            {
                bigInteRow.add(new BigInteger(s.toString()));

            }
            bigIntMatrix.add(bigInteRow);
        }
        return bigIntMatrix;
    }

    public ArrayList<ArrayList<BigInteger>> convertMyString3ToBigInteger(ArrayList<ArrayList<MyString3>> matrix)
    {
        ArrayList<ArrayList<BigInteger>> bigIntMatrix = new ArrayList<ArrayList<BigInteger>>();

        for (ArrayList<MyString3> row : this.matrixB.getMatrix())
        {
            ArrayList<BigInteger> bigInteRow = new ArrayList<BigInteger>();
            for (MyString3 s : row)
            {
                bigInteRow.add(new BigInteger(s.toString()));

            }
            bigIntMatrix.add(bigInteRow);
        }
        return bigIntMatrix;
    }

    public ArrayList<ArrayList<String>> convertBigIntegerToString(ArrayList<ArrayList<BigInteger>> matrix)
    {
        ArrayList<ArrayList<String>> stringMatrix = new ArrayList<ArrayList<String>>();

        for (ArrayList<BigInteger> row : matrix)
        {
            ArrayList<String> stringRow = new ArrayList<String>();
            for (BigInteger bigInt : row)
            {
                stringRow.add(new String(bigInt.toString()));

            }
            stringMatrix.add(stringRow);
        }
        return stringMatrix;
    }

    public MatrixBeanC getMatrixC()
    {
        return this.matrixC;
    }

    public MatrixBeanA getMatrixA()
    {
        return matrixA;
    }

    public MatrixBeanB getMatrixB()
    {
        return matrixB;
    }
    
    public boolean isReadyForAddition()
    {

        return matrixA.getRows() == matrixB.getRows() &&                
               matrixA.getColumns() == matrixB.getColumns();
    }
    public boolean isReadyForMultiplication()
    {
        return  matrixA.getColumns() == matrixB.getRows();
    }  
}
