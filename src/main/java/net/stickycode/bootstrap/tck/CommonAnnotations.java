package net.stickycode.bootstrap.tck;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import net.stickycode.stereotype.StickyComponent;

@StickyComponent
public class CommonAnnotations {

  public boolean postConstructed = false;

  public boolean preDestroyed = false;

  @PostConstruct
  public void postConstruct() {
    postConstructed = true;
  }

  @PreDestroy
  public void destroy() {
    preDestroyed = true;
  }
}