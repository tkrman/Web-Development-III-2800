/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.slcc.asdv.bl;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author ASDV1
 */
public interface Matrix
{
    ArrayList<ArrayList<BigInteger>> addParallel(ArrayList<ArrayList<BigInteger>> A, ArrayList<ArrayList<BigInteger>> B);
    ArrayList<ArrayList<BigInteger>> multiplyParallel(ArrayList<ArrayList<BigInteger>> A, ArrayList<ArrayList<BigInteger>> B);
    
}
