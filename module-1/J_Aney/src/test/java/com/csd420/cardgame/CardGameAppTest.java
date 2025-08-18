package com.csd420.cardgame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Card Game Application
 */
public class CardGameAppTest {
    
    @Test
    public void testCardGameAppExists() {
        // Test that the main class exists and can be instantiated
        assertDoesNotThrow(() -> {
            CardGameApp app = new CardGameApp();
            assertNotNull(app);
        });
    }
    
    @Test
    public void testMainMethodExists() {
        // Test that the main method exists
        assertDoesNotThrow(() -> {
            CardGameApp.class.getMethod("main", String[].class);
        });
    }
}
