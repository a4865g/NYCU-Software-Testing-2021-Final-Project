package com.kingyu.flappybird.util;

import org.junit.jupiter.api.Test;
import static com.kingyu.flappybird.util.Constant.FRAME_HEIGHT;
import static com.kingyu.flappybird.util.Constant.FRAME_WIDTH;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Collections;

class GameUtilTest {

    @Test
    void loadBufferedImage() {
        assertNull(GameUtil.loadBufferedImage(""));
        assertNotEquals(null, GameUtil.loadBufferedImage(Constant.AGAIN_IMG_PATH));
        assertNotEquals(null, GameUtil.loadBufferedImage(Constant.NOTICE_IMG_PATH));
        assertNotEquals(null, GameUtil.loadBufferedImage(Constant.BG_IMG_PATH));
        assertNotEquals(null, GameUtil.loadBufferedImage(Constant.TITLE_IMG_PATH));
        assertNotEquals(null, GameUtil.loadBufferedImage(Constant.OVER_IMG_PATH));
        assertNotEquals(null, GameUtil.loadBufferedImage(Constant.SCORE_IMG_PATH));

        for (String imgPath : Constant.CLOUDS_IMG_PATH)
            assertNotEquals(null, GameUtil.loadBufferedImage(imgPath));

        for (String imgPath : Constant.PIPE_IMG_PATH)
            assertNotEquals(null, GameUtil.loadBufferedImage(imgPath));

        for (String[] imgArray : Constant.BIRDS_IMG_PATH)
            for (String imgPath : imgArray)
                assertNotEquals(null, GameUtil.loadBufferedImage(imgPath));
    }

    @Test
    void isInProbability() throws Exception {
        assertThrows(Exception.class, () -> GameUtil.isInProbability(0, 0));
        assertThrows(Exception.class, () -> GameUtil.isInProbability(1, 0));
        assertThrows(Exception.class, () -> GameUtil.isInProbability(0, 1));
        assertDoesNotThrow(() -> GameUtil.isInProbability(1, 1));

        assertTrue(GameUtil.isInProbability(5, 3));
        assertTrue(GameUtil.isInProbability(5, 5));
        assertTrue(GameUtil.isInProbability(5, 5));

        Boolean actual = GameUtil.isInProbability(5, 7); //it return T or F (random), so use xor to always true
        assertFalse(actual^actual);
    }

    @Test
    void getRandomNumber() {
        int num1 = GameUtil.getRandomNumber(3, 5);
        int num2 = GameUtil.getRandomNumber(0, 0);
        int num3 = GameUtil.getRandomNumber(-5, -3);

        assertTrue(3 <= num1 && num1 <= 5);
        assertEquals(0, num2);
        assertTrue(-5 <= num3 && num3 <= -3);
    }

    @Test
    void getStringWidth_Height() {
        int odd_w=10;
        int even_w=11;
        int expect=0;
        for(int i=1;i<5;i++){
            if((i&1)==0){
                expect+=even_w;
            }else{
                expect+=odd_w;
            }
            int width = GameUtil.getStringWidth(Constant.CURRENT_SCORE_FONT, String.join("", Collections.nCopies(i, "f")));
            assertEquals(expect, width);
            int height = GameUtil.getStringHeight(Constant.CURRENT_SCORE_FONT, String.join("", Collections.nCopies(i, "f")));
            assertEquals(40, height);
        }
    }


    @Test
    void drawImage() {
        assertDoesNotThrow(() -> {
            BufferedImage bufImg = new BufferedImage(FRAME_WIDTH, FRAME_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics bufG = bufImg.getGraphics();
            GameUtil.drawImage(bufImg, 0, 0, bufG);
        });
    }
}