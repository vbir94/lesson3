package com.company.chess.impl;

import com.company.chess.ChessMovement;

import java.math.BigInteger;

public class KnightMovement implements ChessMovement {

    public BigInteger solve(int x) {
        BigInteger noA = new BigInteger("18374403900871474942");
        BigInteger noB = new BigInteger("18229723555195321596");
        BigInteger noH = new BigInteger("9187201950435737471");
        BigInteger noG = new BigInteger("4557430888798830399");

        BigInteger K = new BigInteger(Long.toUnsignedString(1L << x));
        BigInteger Ka = noA.and(K);
        BigInteger Kb = noB.and(K);
        BigInteger Kh = noH.and(K);
        BigInteger Kg = noG.and(K);
        BigInteger result = Ka.shiftLeft(15).or(Ka.shiftRight(17))
                .or(Kb.shiftLeft(6)).or(Kb.shiftRight(10))
                .or(Kh.shiftRight(15)).or(Kh.shiftLeft(17))
                .or(Kg.shiftRight(6)).or(Kg.shiftLeft(10));
        long longResult = result.longValue();
        result = new BigInteger(Long.toUnsignedString(longResult));

        return result;
    }
}
