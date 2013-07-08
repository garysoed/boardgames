//package bgm.common.util;
//
//import com.google.common.base.Supplier;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static junit.framework.Assert.*;
//import static org.mockito.Mockito.when;
//
///**
// *
// */
//@RunWith(JUnit4.class)
//public class ReusingCacheTest {
//
//  @Mock Supplier<Integer> mockSupplier;
//
//  private ReusingCache<Integer> cache;
//
//  @Before
//  public void setUp() {
//    MockitoAnnotations.initMocks(this);
//
//    this.cache = new ReusingCache<>(mockSupplier);
//  }
//
//  @Test
//  public void testGetCallsSupplier() {
//    Integer expectedResult = 1;
//    when(mockSupplier.get()).thenReturn(expectedResult);
//
//    assertSame(expectedResult, cache.get());
//  }
//
//  @Test
//  public void testGetReusesUnusedObject() {
//    Integer expectedResult = 1;
//    when(mockSupplier.get()).thenReturn(expectedResult, 2);
//
//    cache.get();
//    cache.markUnused(expectedResult);
//
//    assertSame(expectedResult, cache.get());
//  }
//
//  @Test
//  public void testMarkUnusedThrowsException() {
//    when(mockSupplier.get()).thenReturn(1);
//
//    cache.get();
//    try {
//      cache.markUnused(2);
//      fail("IllegalArgumentException expected");
//    } catch (IllegalArgumentException e) {
//      assertTrue(e.getMessage().contains("Cannot find"));
//    }
//  }
//}
