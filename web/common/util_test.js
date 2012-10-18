function testNamespace() {
  bgm.namespace("a.b.c");
  assertNotUndefined(a);
  assertNotUndefined(a.b);
  assertNotUndefined(a.b.c);
}

