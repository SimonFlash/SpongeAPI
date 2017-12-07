/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.util;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3f;
import com.flowpowered.math.vector.Vector3i;
import org.apache.commons.lang3.Validate;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.type.DyeColor;

public interface Color extends DataSerializable {

    //16 HTML web colors and CSS orange

    Color WHITE = of(0xFFFFFF);

    Color SILVER = of(0xC0C0C0);

    Color GRAY = of(0x808080);

    Color BLACK = of(0x000000);

    Color RED = of(0xFF0000);

    Color MAROON = of(0x800000);

    Color ORANGE = of(0xFFA500);

    Color YELLOW = of(0xFFFF00);

    Color OLIVE = of(0x808000);

    Color LIME = of(0x00FF00);

    Color GREEN = of(0x008000);

    Color AQUA = of(0x00FFFF);

    Color TEAL = of(0x008080);

    Color BLUE = of(0x0000FF);

    Color NAVY = of(0x000080);

    Color FUCHSIA = of(0xFF00FF);

    Color PURPLE = of(0x800080);

    //Old purple = 0xAA00FF, new purple = 0x800080
    //Color OLD_PURPLE = of(0xAA00FF);

    @Deprecated
    Color MAGENTA = of(0xFF00FF);

    @Deprecated
    Color DARK_CYAN = of(0x008B8B);

    @Deprecated
    Color DARK_GREEN = of(0x006400);

    @Deprecated
    Color DARK_MAGENTA = of(0x8B008B);

    @Deprecated
    Color CYAN = of(0x00FFFF);

    @Deprecated
    Color PINK = of(0xFF00AA);

    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Creates a new {@link Color} based on the red-green-blue (rgb) value for
     * the color. Colors do not utilize an alpha modifier.
     *
     * @param rgb The red-green-blue value
     * @return The color object
     */
    static Color of(int rgb) {
        return builder().rgb(rgb).build();
    }

    /**
     * Creates a new {@link Color} based on the red-green-blue (rgb) value for
     * the color. Colors do not utilize an alpha modifier.
     *
     * @param rgb The red-green-blue value
     * @return The color object
     * @deprecated in favor of {@link #of(int)}
     */
    @Deprecated
    static Color ofRgb(int rgb) {
        return of(rgb);
    }

    /**
     * Creates a new {@link Color} based on the red, green, and blue values.
     *
     * @param red The red value
     * @param green The green value
     * @param blue The blue value
     * @return The color object
     */
    static Color of(int red, int green, int blue) {
        return builder().rgb(red, green, blue).build();
    }

    /**
     * Creates a new {@link Color} based on the red, green, and blue values.
     *
     * @param red The red value
     * @param green The green value
     * @param blue The blue value
     * @return The color object
     * @deprecated in favor of {@link #of(int, int, int)}
     */
    @Deprecated
    static Color ofRgb(int red, int green, int blue) {
        return of(red, green, blue);
    }

    /**
     * Creates a new {@link Color} based on the x (red), y (green), and z (blue)
     * values of the vector.
     *
     * @param vector3i The vector of three integers representing color
     * @return The color object
     */
    static Color of(Vector3i vector3i) {
        return of(vector3i.getX(), vector3i.getY(), vector3i.getZ());
    }

    /**
     * Creates a new {@link Color} based on the x (red), y (green), and z (blue)
     * values of the vector. Values are rounded to the nearest integer.
     *
     * @param vector3f The vector of three floats representing color
     * @return The color object
     * @deprecated Use {@code #of(vector3f.round().toInt())}
     */
    @Deprecated
    static Color of(Vector3f vector3f) {
        return of(vector3f.round().toInt());
    }

    /**
     * Creates a new {@link Color} based on the x (red), y (green), and z (blue)
     * values of the vector. Values are rounded to the nearest integer.
     *
     * @param vector3d The vector of three doubles representing color
     * @return The color object
     * @deprecated Use {@code #of(vector3d.round().toInt())}
     */
    @Deprecated
    static Color of(Vector3d vector3d) {
        return of(vector3d.round().toInt());
    }

    /**
     * Creates a new {@link Color} from a {@link java.awt.Color} for use in the
     * Sponge API.
     *
     * @param color The java color object
     * @return The converted color object
     */
    static Color of(java.awt.Color color) {
        return of(color.getRed(), color.getGreen(), color.getBlue());
    }

    /**
     * Creates a new {@link Color} combining the provided {@link Color} objects,
     * their summation and average is taken into effect to properly mix the
     * colors together.
     *
     * @param colors The colors to mix
     * @return The final output mixed color
     */
    static Color mix(Color... colors) {
        return builder().mix(colors).build();
    }

    /**
     * Creates a new {@link Color} combining the provided {@link Color} objects,
     * their summation and average is taken into effect to properly mix the
     * colors together.
     *
     * @param colors The colors to mix
     * @return The final output mixed color
     * @deprecated in favor of {@link #mix(Color...)}
     */
    @Deprecated
    static Color mixColors(Color... colors) {
        return mix(colors);
    }

    /**
     * Creates a new {@link Color} combining the provided {@link DyeColor}
     * objects. Since {@link DyeColor}s can be converted into {@link Color}
     * objects themselves, their summation and average is taken into effect
     * to properly mix the colors together.
     *
     * @param colors The colors to mix
     * @return The final output mixed color
     * @deprecated If needed, convert to colors first
     */
    @Deprecated
    static Color mixDyeColors(DyeColor... colors) {
        Validate.noNullElements(colors, "No nulls allowed!");
        final Color[] actualColors = new Color[colors.length];
        for (int i = 0; i < colors.length; i++) {
            actualColors[i] = colors[i].getColor();
        }
        return mix(actualColors);
    }

    /**
     * Gets the rgb value of this {@link Color}.
     *
     * @return The rgb value
     */
    int getRgb();

    /**
     * Gets the red value of this {@link Color}.
     *
     * @return The red value
     */
    int getRed();

    /**
     * Gets the current blue value of this {@link Color}.
     *
     * @return The blue value
     */
    int getBlue();

    /**
     * Gets the green value of this {@link Color}.
     *
     * @return The green value
     */
    int getGreen();

    /**
     * Creates a new {@link Color} by using the provided red value while
     * retaining the current green and blue values.
     *
     * @param red The red value to use
     * @return The new color object
     */
    default Color withRed(int red) {
        return of(red, getGreen(), getBlue());
    }

    /**
     * Creates a new {@link Color} by using the provided green value while
     * retaining the current red and blue values.
     *
     * @param green The green value to use
     * @return The new color object
     */
    default Color withGreen(int green) {
        return of(getRed(), green, getBlue());
    }

    /**
     * Creates a new {@link Color} by using the provided blue value while
     * retaining the current green and blue values.
     *
     * @param blue The blue value to use
     * @return The new color object
     */
    default Color withBlue(int blue) {
        return of(getRed(), getGreen(), blue);
    }

    /**
     * Converts this {@link Color} into a {@link Vector3i} object of red (x),
     * green (y), and blue (z) values.
     *
     * @return The vector rgb color
     */
    default Vector3i toVector3i() {
        return new Vector3i(getRed(), getGreen(), getBlue());
    }

    /**
     * Converts this {@link Color} into a {@link java.awt.Color} object for use
     * in other APIs.
     *
     * @return The java awt color object
     */
    default java.awt.Color toJavaColor() {
        return new java.awt.Color(getRed(), getGreen(), getBlue());
    }

    /**
     * Converts this {@link Color} into a {@link java.awt.Color} object for use
     * in other APIs.
     *
     * @return The java awt color object
     * @deprecated in favor of {@link #toJavaColor()}
     */
    @Deprecated
    default java.awt.Color asJavaColor() {
        return toJavaColor();
    }

    /**
     * Creates a new {@link Color} by averaging the red, green, and blue values
     * of each color in the array.
     *
     * @param colors The colors to mix
     * @return The new color
     * @see #mixColors(Color...)
     */
    @Deprecated
    default Color mixWithColors(Color... colors) {
        Color[] newColorArray = new Color[colors.length + 1];
        newColorArray[0] = this;
        System.arraycopy(colors, 0, newColorArray, 1, colors.length);
        return mixColors(newColorArray);
    }

    /**
     * Creates a new {@link Color} by averaging the red, green, and blue values
     * of each color in the array.
     *
     * @param dyeColors The dye colors to mix
     * @return The new color
     * @deprecated Use {@link #mixColors(Color...)}
     */
    @Deprecated
    default Color mixWithDyes(DyeColor... dyeColors) {
        Color[] newColorArray = new Color[dyeColors.length + 1];
        newColorArray[0] = this;
        for (int i = 0; i < dyeColors.length; i++) {
            newColorArray[i + 1] = dyeColors[i].getColor();
        }
        return mixColors(newColorArray);
    }

    interface Builder extends DataBuilder<Color> {

        /**
         * Sets the rgb value for this color. An alpha value will be stripped.
         *
         * @param rgb The red-green-blue value
         * @return This builder
         */
        Builder rgb(int rgb);

        /**
         * Sets the rgb value for this color using red, green, and blue values.
         * Values outside the range of 0 through 255 (0xFF) inclusive will be
         * brought in range using {@code value & 0xFF}.
         *
         * @param red The red value
         * @return This builder
         */
        Builder rgb(int red, int green, int blue);

        /**
         * Sets the red, green, and blue values for this color by taking the
         * average of each for every color in the array.
         *
         * @param colors The colors to mix
         * @return This builder
         */
        Builder mix(Color... colors);

        /**
         * Builds and returns the color represented by this builder.
         *
         * @return The new color
         */
        Color build();

    }

}