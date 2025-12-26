package com.example.refactoringworkbook.chapter3.example4;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

public class Report2 {
    public static void report(Writer out, List<Machine> machines, Robot robot) throws IOException {
        writeHeader(out);
        writeMachines(out, machines);
        writeRobot(out, robot);
        writeFooter(out);
    }

    private static void writeRobot(Writer out, Robot robot) throws IOException {
        out.write(robot.report());
        out.write("\n");
    }

    private static void writeMachines(Writer out, List<Machine> machines) throws IOException {
        Iterator line = machines.iterator();
        while (line.hasNext()) {
            Machine machine = (Machine) line.next();
            out.write(machine.report());
        }

        out.write("\n");
    }

    private static void writeHeader(Writer out) throws IOException {
        out.write("FACTORY REPORT\n");
    }

    private static void writeFooter(Writer out) throws IOException {
        out.write("========\n");
    }
}
