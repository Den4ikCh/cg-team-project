package ru.vsu.cg.math;

import java.util.Objects;

/**
 * Двумерный вектор (x, y).
 * Неизменяемый: все операции возвращают новый вектор.
 */
public final class Vector2 {
    public final double x;
    public final double y;

    public static final Vector2 ZERO = new Vector2(0, 0);

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Сложение
    public Vector2 add(Vector2 other) {
        return new Vector2(x + other.x, y + other.y);
    }

    // Вычитание
    public Vector2 sub(Vector2 other) {
        return new Vector2(x - other.x, y - other.y);
    }

    // Умножение на скаляр
    public Vector2 mul(double scalar) {
        return new Vector2(x * scalar, y * scalar);
    }

    // Деление на скаляр
    public Vector2 div(double scalar) {
        if (scalar == 0) throw new ArithmeticException("Нельзя делить на 0");
        return new Vector2(x / scalar, y / scalar);
    }

    // Скалярное произведение
    public double dot(Vector2 other) {
        return x * other.x + y * other.y;
    }

    // Длина
    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    // Нормализация
    public Vector2 normalized() {
        double len = length();
        if (len == 0) throw new ArithmeticException("Невозможно нормализовать нулевой вектор");
        return div(len);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vector2 vector2)) return false;
        return Double.compare(x, vector2.x) == 0 && Double.compare(y, vector2.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("{%f; %f}", x, y);
    }
}