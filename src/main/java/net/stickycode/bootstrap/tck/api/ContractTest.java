package net.stickycode.bootstrap.tck.api;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;
import javax.inject.Provider;

import org.junit.Test;

import net.stickycode.bootstrap.StickyBootstrap;

public class ContractTest {

  @Inject
  TestBean bean;

  @Test
  public void singleton() {
    StickyBootstrap crank = StickyBootstrap.crank();
    TestBean b = new TestBean();
    crank.registerSingleton("b", b, TestBean.class);
    assertThat(crank.canFind(TestBean.class)).isTrue();
    crank.inject(this);
    assertThat(bean).isSameAs(b);
  }

  @Test
  public void type() {
    StickyBootstrap crank = StickyBootstrap.crank();
    crank.registerType("testBean", TestBean.class);
    assertThat(crank.canFind(TestBean.class)).isTrue();
    crank.inject(this);
    assertThat(bean).isNotNull();
  }

  @Test
  public void provider() {
    StickyBootstrap crank = StickyBootstrap.crank();
    TestBean b = new TestBean();
    crank.registerProvider("b", new Provider<Object>() {

      @Override
      public Object get() {
        return b;
      }
    }, TestBean.class);
    crank.inject(this);
    assertThat(bean).isSameAs(b);
  }

}
