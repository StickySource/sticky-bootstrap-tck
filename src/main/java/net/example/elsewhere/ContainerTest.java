package net.example.elsewhere;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import net.stickycode.bootstrap.ComponentContainer;
import net.stickycode.bootstrap.StickyBootstrap;

public class ContainerTest {

  @Inject
  ComponentContainer container;

  @Before
  public void setup() {
    StickyBootstrap.crank(this, getClass());
  }

  @Test
  public void container() {
    assertThat(container.find(ComponentContainer.class)).isNotNull();
  }

  @Test
  public void childInjector() {
    OtherBean find = container.find(OtherBean.class);
    assertThat(find).isNotNull();
    assertThat(find.container).isNotNull();
  }
}
