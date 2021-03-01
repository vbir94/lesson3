package com.company.chess.impl;

import com.company.chess.ChessMovement;

import java.math.BigInteger;

public class KingMovement implements ChessMovement {

    public BigInteger solve(int x) {
        BigInteger noA = new BigInteger("18374403900871474942");
        BigInteger noH = new BigInteger("9187201950435737471");

        BigInteger K = new BigInteger(Long.toUnsignedString(1L << x));
        BigInteger Ka = noA.and(K);
        BigInteger Kh = noH.and(K);
        BigInteger result = Ka.shiftLeft(7).or(K.shiftLeft(8)).or(Kh.shiftLeft(9))
                .or(Ka.shiftRight(1)).or(Kh.shiftLeft(1))
                .or(Ka.shiftRight(9)).or(K.shiftRight(8)).or(Kh.shiftRight(7));
        long longResult = result.longValue();
        result = new BigInteger(Long.toUnsignedString(longResult));

        return result;
    }
}
