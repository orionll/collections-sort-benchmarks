How to run benchmarks:
```
mvn clean install
java -jar target/microbenchmarks.jar -w 1 -i 5
```

Results on my machine:
```
java version "1.7.0_25"
Java(TM) SE Runtime Environment (build 1.7.0_25-b17)
Java HotSpot(TM) 64-Bit Server VM (build 23.25-b01, mixed mode)

Benchmark                            Mode Thr    Cnt  Sec         Mean   Mean error    Units
o.s.MyBenchmark.sort                 avgt   1      5    5        6.795        0.267    ms/op
o.s.MyBenchmark.sortColt             avgt   1      5    5       91.114        1.589    ms/op
o.s.MyBenchmark.sortColtReversed     avgt   1      5    5       60.210        0.801    ms/op
o.s.MyBenchmark.sortReversed         avgt   1      5    5        6.734        0.322    ms/op
