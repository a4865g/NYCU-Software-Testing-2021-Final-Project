package com.kingyu.flappybird.component;

import com.kingyu.flappybird.util.Constant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PipePoolTest {
    @Test
    @Order(1)
    void t1_get() {
        for(int i=PipePool.get_pool_size();i>0;i--){
            PipePool.get("Pipe");
            PipePool.get("MovingPipe");
            assertEquals(i-1, PipePool.get_pool_size());
            assertEquals(i-1, PipePool.get_movingPool_size());
        }
        Pipe p=PipePool.get("Pipe");
        Pipe mp=PipePool.get("MovingPipe");
        assertNotNull(p);
        assertNotNull(mp);
    }

    @Test
    @Order(2)
    void t2_giveback() {
        PipePool p = new PipePool();

        Pipe pipe = new Pipe();
        MovingPipe movingpipe = new MovingPipe();

        List<Pipe> want_pipe = p.get_pipe();
        List<MovingPipe> want_movingpipe = p.get_movingpipe();

        p.giveBack(pipe);
        List<Pipe> return_pipe = p.get_pipe();
        List<MovingPipe> return_moving_pipe = p.get_movingpipe();

        want_pipe.add(pipe);
        assertTrue(return_pipe.size() == want_pipe.size() &&
                return_pipe.containsAll(want_pipe) &&
                want_pipe.containsAll(return_pipe) &&
                return_moving_pipe.size() == want_movingpipe.size() &&
                return_moving_pipe.containsAll(want_movingpipe) &&
                want_movingpipe.containsAll(return_moving_pipe));

        p.giveBack(movingpipe);
        want_movingpipe.add(movingpipe);
        assertTrue(return_pipe.size() == want_pipe.size() &&
                return_pipe.containsAll(want_pipe) &&
                want_pipe.containsAll(return_pipe) &&
                return_moving_pipe.size() == want_movingpipe.size() &&
                return_moving_pipe.containsAll(want_movingpipe) &&
                want_movingpipe.containsAll(return_moving_pipe));

    }
}