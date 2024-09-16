package com.leosvjetlicic.calendarlibrary.ui.calendarheader.basecontent

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Composable function that renders a customizable icon button with a specific shape.
 *
 * This function allows you to define a button with an icon and apply different
 * styles such as shape, size, padding, and tint. The default shape is circular,
 * but you can pass any custom shape.
 *
 * @param iconId The resource ID of the drawable used as the icon.
 *               This should refer to a valid drawable resource.
 * @param modifier A [Modifier] to apply customization such as padding, shape, or size.
 * @param shape The shape of the button. Defaults to a circular button ([CircleShape]),
 *              but can be changed to any shape like a rectangle or custom shape.
 *              Changing this value alters how the button is displayed.
 * @param contentDescription A description for accessibility purposes (used by screen readers).
 *                           Useful when the icon conveys important information or action.
 * @param iconTint The color applied to the icon. The default is black, but you can change it
 *                 to any color (e.g., white for light backgrounds). Adjusting this changes
 *                 the visual appearance of the icon.
 * @param paddingValues The padding around the icon within the button.
 *                      By default, 6.dp is used to give spacing inside the button.
 *                      Changing this alters the spacing between the icon and the button edges.
 * @param iconSize The size of the icon itself. Set to 20.dp by default, but can be resized.
 *                 Adjusting this value changes how large the icon appears inside the button.
 * @param onClick A lambda that is triggered when the button is clicked.
 *                The button is interactive and will perform this action upon user click.
 */
@Composable
fun BaseActionButtonContent(
    @DrawableRes iconId: Int,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    contentDescription: String = "",
    iconTint: Color = Black,
    paddingValues: PaddingValues = PaddingValues(6.dp),
    iconSize: Dp = 20.dp,
    onClick: () -> Unit
) {
    Icon(
        modifier = modifier
            .clip(shape)
            .clickable { onClick() }
            .padding(paddingValues)
            .size(iconSize),
        painter = painterResource(id = iconId),
        contentDescription = contentDescription,
        tint = iconTint
    )
}
