package net.stickycode.bootstrap.tck;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.stickycode.bootstrap.StickyBootstrap;

public class WiringTest {

  @Inject
  CommonAnnotations common;

  @Test
  public void verify() {
    assertThat(common.preDestroyed).isFalse();
    assertThat(common.postConstructed).isTrue();
  }

  StickyBootstrap crank;

  @Before
  public void setup() {
    crank = StickyBootstrap.crank(this, getClass());
    assertThat(common.postConstructed).isTrue();
  }

  @After
  public void after() {
    assertThat(common.preDestroyed).isFalse();
    crank.shutdown();
    assertThat(common.preDestroyed).isTrue();
  }
}
