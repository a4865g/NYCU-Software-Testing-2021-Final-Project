package com.kingyu.flappybird.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import static com.kingyu.flappybird.util.Constant.FRAME_HEIGHT;
import static com.kingyu.flappybird.util.Constant.FRAME_WIDTH;
import static org.junit.jupiter.api.Assertions.*;

class GameElementLayerTest {

    private BufferedImage bufImg;
    private Graphics bufG;
    private GameElementLayer game;
    Bird bird;
    @BeforeEach
    void setUp() {
        bufImg = new BufferedImage(FRAME_WIDTH, FRAME_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        bufG = bufImg.getGraphics();
        game = new GameElementLayer();

        bird = new Bird();
    }
    @Test
    void isCollideBird() {
        assertDoesNotThrow(() -> {
            game.isCollideBird(bird);
        });
        assertDoesNotThrow(() -> {
            bird.deadBirdFall();
            game.draw(bufG,bird);
            game.isCollideBird(bird);
        });
    }

    @Test
    void reset() {
        game.draw(bufG, bird);
        game.draw(bufG, bird); //for new pipe
        game.reset();
        List<Pipe> get_pipe = game.get_pipe();
        List<Pipe> want_pipe = new ArrayList<>();
        assertTrue(get_pipe.size() == want_pipe.size() &&
                get_pipe.containsAll(want_pipe) &&
                want_pipe.containsAll(get_pipe));
    }
}