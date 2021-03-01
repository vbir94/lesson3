package com.company.chess.impl;

import com.company.chess.ChessMovement;

import java.math.BigInteger;

public class RookMovement implements ChessMovement {

    @Override
    public BigInteger solve(int x) {
        BigInteger noA = new BigInteger("18374403900871474942");
        BigInteger noH = new BigInteger("9187201950435737471");
        BigInteger no8 = new BigInteger("72057594037927935");
        BigInteger no1 = new BigInteger("18446744073709551360");

        String stringK = Long.toUnsignedString(1L << x);

        BigInteger K = new BigInteger(stringK);

        BigInteger rightK = new BigInteger(stringK);
        BigInteger leftK = new BigInteger(stringK);
        BigInteger upK = new BigInteger(stringK);
        BigInteger downK = new BigInteger(stringK);

        BigInteger result = BigInteger.ZERO;
        //RIGHT
        if (K.and(noH).equals(BigInteger.ZERO)) {
            rightK = BigInteger.ZERO;
        } else {
            for (int i = 1; i < 8; i++) {
                rightK = rightK.or(rightK.shiftLeft(1));
                if (K.shiftLeft(i).and(noH).equals(BigInteger.ZERO)) break;
            }
        }
        //LEFT
        if (K.and(noA).equals(BigInteger.ZERO)) {
            leftK = BigInteger.ZERO;
        } else {
            for (int i = 1; i < 8; i++) {
                leftK = leftK.or(leftK.shiftRight(1));
                if (K.shiftRight(i).and(noA).equals(BigInteger.ZERO)) break;
            }
        }
        //UP
        if (K.and(no8).equals(BigInteger.ZERO)) {
            upK = BigInteger.ZERO;
        } else {
            for (int i = 1; i < 8; i++) {
                upK = upK.or(upK.shiftLeft(8));
                if (K.shiftLeft(i*8).and(no8).equals(BigInteger.ZERO)) break;
            }
        }
        //DOWN
        if (K.and(no1).equals(BigInteger.ZERO)) {
            downK = BigInteger.ZERO;
        } else {
            for (int i = 1; i < 8; i++) {
                downK = downK.or(downK.shiftRight(8));
                if (K.shiftRight(i*8).and(no1).equals(BigInteger.ZERO)) break;
            }
        }

        return result.or(rightK)
                .or(leftK)
                .or(upK)
                .or(downK)
                .xor(K);
    }
}
