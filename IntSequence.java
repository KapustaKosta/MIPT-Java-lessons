public interface IntSequence {
  public static IntSequence of(int... values) {
    return new IntSequence() {
      private int index = 0;

      public int next() {
        if (index >= values.length) {
          throw new RuntimeException("End of sequence");
        }
        return values[index++];
      }
    };
  }

  public static IntSequence constant(int value) {
      return new IntSequence() {
        public int next() {
          return value;
        }
      };
  }

  public int next();
}
