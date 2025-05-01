public enum Style {
  A, F;

  public String toString() {
    switch(this) {
      case A: return "Fanciful A style";
      case F: return "Forwarding F style";
      default: return "Unspecified";
    }
  }
}