/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package benchmark;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Measurement(iterations = 3, time = 1)
@Warmup(iterations = 3, time = 1)
@Fork(1)
@State(Scope.Thread)
public class MyBenchmark {
    private int[] dset = {10,11,11,2,8,13,2,7,8,9,11,11,7,8};
    private int[] num = {5,4,3,2,1};
    @Setup(Level.Invocation)
    public void doSetup() {
    }

    @TearDown(Level.Trial)
    public void doTearDown() {
        System.out.println("Do tear down");
    }

    @Benchmark
    public void bubblesortTest() {
        SortExamples.bubbleSort(num);
    }

    @Benchmark
    public void mergeSortTest() {
        SortExamples.mergeSort(num);
    }

//    @Benchmark
//    public void quickUnionV1() {
//        UnionExamples.quickUnionv1(dset,3,4);
//    }

    public static void main(String[] args) throws RunnerException, IOException {
        Main.main(args);
    }

}
