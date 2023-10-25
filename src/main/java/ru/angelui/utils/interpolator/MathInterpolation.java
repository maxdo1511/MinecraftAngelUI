package ru.angelui.utils.interpolator;

public class MathInterpolation {

    double start_value, end_value, current_value, factor = 1, start_time = -1, start_value_repeat_amount = 0, last_it_value = 0, sign_changes = 0;
    String tag = "";
    boolean isDecreasing = false, end = false;
    InterpolationMode mode = InterpolationMode.LINE;


    public MathInterpolation(double start_value, double end_value, double delta_time, InterpolationMode mode) {
        factor = solveFactor(start_value, end_value, delta_time, mode);
        this.start_value = start_value;
        this.end_value = end_value;
        this.mode = mode;
        this.current_value = start_value;
    }

    public MathInterpolation(double start_value, double end_value, InterpolationMode mode, double factor) {
        this.start_value = start_value;
        this.end_value = end_value;
        this.mode = mode;
        this.current_value = start_value;
        this.factor = factor;
    }

    public MathInterpolation(double start_value, double end_value, double delta_time) {
        factor = solveFactor(start_value, end_value, delta_time, mode);
        this.start_value = start_value;
        this.end_value = end_value;
        this.current_value = start_value;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public double getEnd_value() {
        return end_value;
    }

    /**
     @param time текущее время в секундах
     */
    public double getValue(double time) {
        if (start_time == -1) {
            start_time = time;
            last_it_value = start_value;
            isDecreasing = start_value < end_value;
            return start_value;
        }
        time = (time - start_time) / 1000;
        double value = 0;
        if (mode.equals(InterpolationMode.LINE)) {
            value = f_line(time);
            if (value == end_value) {
                end = true;
            }
        }
        if (mode.equals(InterpolationMode.SIN_HALF_PERIOD)) {
            value = f_sin(time);
        }
        if (mode.equals(InterpolationMode.SIN_FULL_PERIOD)) {
            value = f_sin(time);
        }
        if (mode.equals(InterpolationMode.DEGREE_2)) {
            value = f_degree(time, 2);
            if (value == end_value) {
                end = true;
            }
        }
        if (mode.equals(InterpolationMode.SQUARE)) {
            value = f_degree(time, 0.5);
            if (value == end_value) {
                end = true;
            }
        }
        if (value == start_value) {
            start_value_repeat_amount++;
        }
        last_it_value = value;
        return value;
    }

    public boolean isEnd() {
        return end;
    }

    private double solveFactor(double start_value, double end_value, double delta_time, InterpolationMode mode) {
        if (mode.equals(InterpolationMode.LINE)) {
            return (end_value - start_value) / delta_time;
        }
        if (mode.equals(InterpolationMode.SIN_HALF_PERIOD)) {
            return Math.PI / delta_time;
        }
        if (mode.equals(InterpolationMode.SIN_FULL_PERIOD)) {
            return Math.PI * 2 / delta_time;
        }
        double znak = (end_value - start_value) / Math.abs(end_value - start_value);
        if (mode.equals(InterpolationMode.DEGREE_2)) {
            return znak * Math.sqrt(Math.abs(end_value - start_value)) / delta_time;
        }
        if (mode.equals(InterpolationMode.SQUARE)) {
            return znak * Math.abs(end_value - start_value) / Math.pow(delta_time, 0.5);
        }
        return 0;
    }

    private double f_line(double time) {
        double res = start_value + factor * time;
        if (start_value < end_value && res > end_value){
            res = end_value;
        }
        if (start_value > end_value && res < end_value) {
            res = end_value;
        }
        return res;
    }

    private double f_degree(double time, double degree) {
        double res = start_value + (factor / Math.abs(factor)) * factor * Math.pow(time, degree);
        if (start_value < end_value && res > end_value){
            res = end_value;
        }
        if (start_value > end_value && res < end_value) {
            res = end_value;
        }
        return res;
    }

    private double f_sin(double time) {
        double res = end_value * Math.sin(factor * time) + start_value;
        if (last_it_value < res != isDecreasing) {
            res = (end_value + start_value) * (Math.abs(res) / res);
            isDecreasing = !isDecreasing;
        }else {
            if (Math.abs(res) > end_value + start_value) {
                res = (end_value + start_value) * (Math.abs(res) / res);
            }
        }
        if (isChangeSign(res)) {
            sign_changes++;
        }
        if (sign_changes == 2 && mode.equals(InterpolationMode.SIN_FULL_PERIOD)) {
            end = true;
        }
        if (sign_changes == 1 && mode.equals(InterpolationMode.SIN_HALF_PERIOD)) {
            end = true;
        }
        return res;
    }

    private boolean isChangeSign(double res) {
        if (res == 0 || last_it_value == 0) {
            return false;
        }
        return Math.abs(last_it_value) / last_it_value != Math.abs(res) / res;
    }

}
