/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

package org.sample;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import cern.colt.list.ObjectArrayList;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MyBenchmark {

    private static final int SIZE = 1000000;

    List<Integer> list;
    ObjectArrayList listColt;
    List<Integer> listReversed;
    ObjectArrayList listColtReversed;

    @Setup
    public void prepare() {
        list = new ArrayList<Integer>();
        listColt = new ObjectArrayList();
        listReversed = new ArrayList<Integer>();
        listColtReversed = new ObjectArrayList();

        for (int i = 0; i < SIZE; i++) {
            list.add(i);
            listColt.add(i);
            listReversed.add(SIZE - i);
            listColtReversed.add(SIZE - i);
        }
    }


    @GenerateMicroBenchmark
    public List<Integer> sort() {
        Collections.sort(list);
        return list;
    }

    @GenerateMicroBenchmark
    public ObjectArrayList sortColt() {
        listColt.sort();
        return listColt;
    }

    @GenerateMicroBenchmark
    public List<Integer> sortReversed() {
        Collections.sort(listReversed);
        return listReversed;
    }

    @GenerateMicroBenchmark
    public ObjectArrayList sortColtReversed() {
        listColtReversed.sort();
        return listColtReversed;
    }

}
