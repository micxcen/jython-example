package land.valko.example;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class AccumulatorFactory {

    private PyObject classObject;

    public AccumulatorFactory() {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("from accumulator import MyAccumulator");
        classObject = interpreter.get("MyAccumulator");
    }

    public Accumulator create() {
        PyObject accumulator = classObject.__call__();
        return (Accumulator) accumulator.__tojava__(Accumulator.class);
    }
}
