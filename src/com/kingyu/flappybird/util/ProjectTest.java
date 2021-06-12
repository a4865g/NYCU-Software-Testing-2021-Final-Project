package com.kingyu.flappybird.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
public class ProjectTest {
    GameUtil_public gameUtil;

    @BeforeEach
    public void setUp(){
        gameUtil=new GameUtil_public();
    }

    //PC:true
    /*
    (-1 <= 0 || -1 <= 0)  (T||T)
     */
    @Test
    public void PC_1_T() throws Exception {
        int numerator;
        int denominator;
        numerator=-1;
        denominator=-1;
        assertThrows(Exception.class,()->gameUtil.isInProbability(numerator,denominator));
    }

    //PC:false
    /*
    (2 <= 0 || 3 <= 0)  (F||F)
     */
    @Test
    public void PC_1_F() throws Exception {
        int numerator;
        int denominator;
        numerator=2;
        denominator=3;
        assertDoesNotThrow(()->gameUtil.isInProbability(numerator,denominator));
    }

    //PC:true
    /*
    (3>=1)  (T)
     */
    @Test
    public void PC_2_T() throws Exception {
        int numerator;
        int denominator;
        numerator=3;
        denominator=1;
        assertTrue(gameUtil.isInProbability(numerator,denominator));
    }

    //PC:false
    /*
    (1000>=1001)  (F)
     */
    @Test
    public void PC_2_F() throws Exception {

        int numerator;
        int denominator;
        numerator=1000;
        denominator=1001;
        boolean a=gameUtil.isInProbability(numerator,denominator);
        assertFalse(a^a);

    }

    //CC:true
    /*
    (-1 <= 0 || -1 <= 0)  (T||T)
     */
    @Test
    public void CC_1_T() throws Exception {
        int numerator;
        int denominator;
        numerator=-1;
        denominator=-1;
        assertThrows(Exception.class,()->gameUtil.isInProbability(numerator,denominator));
    }

    //CC:false
    /*
    (2 <= 0 || 3 <= 0)  (F||F)
     */
    @Test
    public void CC_1_F() throws Exception {
        int numerator;
        int denominator;
        numerator=2;
        denominator=3;
        assertDoesNotThrow(()->gameUtil.isInProbability(numerator,denominator));
    }

    //CC:true
    /*
    (3>=1)  (T)
     */
    @Test
    public void CC_2_T() throws Exception {
        int numerator;
        int denominator;
        numerator=3;
        denominator=1;
        assertTrue(gameUtil.isInProbability(numerator,denominator));
    }

    //CC:false
    /*
    (1000>=1001)  (F)
     */
    @Test
    public void CC_2_F() throws Exception {
        int numerator;
        int denominator;
        numerator=1000;
        denominator=1001;
        boolean a=gameUtil.isInProbability(numerator,denominator);
        assertFalse(a^a);
    }

    /*
    A:T B:F
    (-1 <= 0 || 3 <= 0)  (T)
     */
    @Test
    public void CACC_A_2() throws Exception {
        int numerator;
        int denominator;
        numerator=-1;
        denominator=3;
        assertThrows(Exception.class,()->gameUtil.isInProbability(numerator,denominator));
    }

    /*
    A:F B:F
    (3 <= 0 || 2 <= 0)  (F)
     */
    @Test
    public void CACC_A_4() throws Exception {
        int numerator;
        int denominator;
        numerator=3;
        denominator=2;
        assertDoesNotThrow(()->gameUtil.isInProbability(numerator,denominator));
    }

    /*
    A:F B:T
    (3 <= 0 || -1 <= 0)  (T)
     */
    @Test
    public void CACC_B_3() throws Exception {
        int numerator;
        int denominator;
        numerator=3;
        denominator=-1;
        assertThrows(Exception.class,()->gameUtil.isInProbability(numerator,denominator));
    }

}

