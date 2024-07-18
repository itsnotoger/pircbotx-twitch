module org.pircbotx {
  requires static lombok;
  requires com.google.common;
  requires org.apache.commons.lang3;
  requires org.slf4j;
  requires org.jetbrains.annotations;
  exports org.pircbotx;
  exports org.pircbotx.cap;
  exports org.pircbotx.exception;
  exports org.pircbotx.hooks;
  exports org.pircbotx.hooks.events;
  exports org.pircbotx.hooks.managers;
  exports org.pircbotx.hooks.types;
  exports org.pircbotx.snapshot;
  exports org.pircbotx.output;
  exports org.pircbotx.dcc;
}