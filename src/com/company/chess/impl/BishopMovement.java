package com.company.chess.impl;

import com.company.chess.ChessMovement;

import java.math.BigInteger;

public class BishopMovement implements ChessMovement {

    @Override
    public BigInteger solve(int x) {
        BigInteger noA = new BigInteger("18374403900871474942");
        BigInteger noH = new BigInteger("9187201950435737471");
        BigInteger no8 = new BigInteger("72057594037927935");
        BigInteger no1 = new BigInteger("18446744073709551360");

        String stringK = Long.toUnsignedString(1L << x);

        BigInteger K = new BigInteger(stringK);

        BigInteger upRightK = new BigInteger(stringK);
        BigInteger upLeftK = new BigInteger(stringK);
        BigInteger downRightK = new BigInteger(stringK);
        BigInteger downLeftK = new BigInteger(stringK);

        //UP-RIGHT
        if (K.and(noH).equals(BigInteger.ZERO) || K.and(no8).equals(BigInteger.ZERO)) {
            upRightK = BigInteger.ZERO;
        } else {
            for (int i = 1; i < 8; i++) {
                upRightK = upRightK.or(upRightK.shiftLeft(9));
                if (K.shiftLeft(9*i).and(noH).equals(BigInteger.ZERO) ||
                        K.shiftLeft(9*i).and(no8).equals(BigInteger.ZERO)) break;
            }
        }
        //UP-LEFT
        if (K.and(noA).equals(BigInteger.ZERO) || K.and(no8).equals(BigInteger.ZERO)) {
            upLeftK = BigInteger.ZERO;
        } else {
            for (int i = 1; i < 8; i++) {
                upLeftK = upLeftK.or(upLeftK.shiftLeft(7));
                if (K.shiftLeft(7*i).and(noA).equals(BigInteger.ZERO) ||
                        K.shiftLeft(7*i).and(no8).equals(BigInteger.ZERO)) break;
            }
        }
        //DOWN-RIGHT
        if (K.and(noH).equals(BigInteger.ZERO) || K.and(no1).equals(BigInteger.ZERO)) {
            downRightK = BigInteger.ZERO;
        } else {
            for (int i = 1; i < 8; i++) {
                downRightK = downRightK.or(downRightK.shiftRight(7));
                if (K.shiftRight(7*i).and(noH).equals(BigInteger.ZERO) ||
                        K.shiftRight(7*i).and(no1).equals(BigInteger.ZERO)) break;
            }
        }
        //DOWN-LEFT
        if (K.and(noA).equals(BigInteger.ZERO) || K.and(no1).equals(BigInteger.ZERO)) {
            downLeftK = BigInteger.ZERO;
        } else {
            for (int i = 1; i < 8; i++) {
                downLeftK = downLeftK.or(downLeftK.shiftRight(9));
                if (K.shiftRight(9*i).and(noA).equals(BigInteger.ZERO) ||
                        K.shiftRight(9*i).and(no1).equals(BigInteger.ZERO)) break;
            }
        }

        BigInteger result =  upRightK
                .or(upLeftK)
                .or(downRightK)
                .or(downLeftK)
                .xor(K);

        long longResult = result.longValue();
        result = new BigInteger(Long.toUnsignedString(longResult));
        return result;
    }
}
