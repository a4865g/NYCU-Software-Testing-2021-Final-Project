package com.kingyu.flappybird.app;

import static org.junit.jupiter.api.Assertions.*;

import com.kingyu.flappybird.component.Bird;
import com.kingyu.flappybird.component.GameElementLayer;
import com.kingyu.flappybird.component.ScoreCounter;
import com.kingyu.flappybird.component.WelcomeAnimation;
import org.junit.jupiter.api.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import static com.kingyu.flappybird.util.Constant.*;

class GameTest {

    private static int gameState; // 游戏状态
    public static final int GAME_READY = 0; // 游戏未开始
    public static final int GAME_START = 1; // 游戏开始
    public static final int STATE_OVER = 2;
    private BufferedImage bufImg;

    Game g = new Game();
    Robot robot=new Robot();

    GameTest() throws AWTException {
    }
    void touch_space(){
        robot.keyPress(KeyEvent.VK_SPACE);
        try{Thread.sleep(50);}catch(InterruptedException e){}
        robot.keyRelease(KeyEvent.VK_SPACE);
    }

    @BeforeEach
    void setUp() {
        bufImg = new BufferedImage(FRAME_WIDTH, FRAME_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void update() {
        WelcomeAnimation wa = new WelcomeAnimation();
        GameElementLayer ge = new GameElementLayer();
        g.setGameState(GAME_READY);
        Graphics bufG = bufImg.getGraphics();
        assertDoesNotThrow(()->{g.update(bufG);});
        assertDoesNotThrow(()->{wa.draw(bufG);});
        g.setGameState(GAME_START);
        assertDoesNotThrow(()->{Bird bird= new Bird();ge.draw(bufG,bird);});
    }

    @Test
    @Order(2)
    void setGameState() {
        g.setGameState(g.GAME_READY);
        assertEquals(GAME_READY, g.getGameState()); //use extra method to check state value
        g.setGameState(g.GAME_START);
        assertEquals(GAME_START, g.getGameState()); //use extra method to check state value
    }

    @Test
    @Order(3)
    void test_runGame() throws InterruptedException {
        g.requestFocus();
        g.setGameState(g.GAME_READY);
        assertEquals(GAME_READY, g.getGameState()); //use extra method to check state value
        Thread.sleep(1000);
        touch_space();
        Thread.sleep(300);
        assertEquals(GAME_START, g.getGameState()); //use extra method to check state value
        touch_space();
        Thread.sleep(1000);
        assertEquals(STATE_OVER, g.getGameState()); //use extra method to check state value
        Thread.sleep(100);
        touch_space();
        assertEquals(GAME_READY, g.getGameState()); //use extra method to check state value
        Thread.sleep(1000);
    }


}