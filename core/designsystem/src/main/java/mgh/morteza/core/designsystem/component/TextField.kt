package mgh.morteza.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mgh.morteza.core.designsystem.ALPHA_ON_SURFACE_VARIANT_MEDIUM_EMPHASIS
import mgh.morteza.core.designsystem.theme.NotimojiTheme

@Composable
fun NotimojiTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: Shape = CircleShape,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        unfocusedBorderColor = Color.Transparent,
        focusedContainerColor = MaterialTheme.colorScheme.surfaceContainer,
        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainer,
        unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(
            alpha = ALPHA_ON_SURFACE_VARIANT_MEDIUM_EMPHASIS
        ),
        focusedLeadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        unfocusedLeadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        focusedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
        unfocusedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
    )
) {
    var isFocused by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .onFocusChanged {
                isFocused = it.isFocused
            },
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        label = {
            if (isFocused.not() && value.isEmpty()) {
                label?.invoke()
            }
        },
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        shape = shape,
        colors = colors,
        singleLine = true,
    )
}

@Preview
@Composable
private fun NotimojiTextFieldEmptyPreview() = NotimojiTheme {
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(25.dp)
    ) {
        NotimojiTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Search notes")
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    imageVector = Icons.Rounded.Call,
                    contentDescription = null
                )
            },
        )
    }
}

@Preview
@Composable
private fun NotimojiTextFieldPreview() = NotimojiTheme {
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(25.dp)
    ) {
        NotimojiTextField(
            value = "This is a text",
            onValueChange = {},
            label = {
                Text(text = "Search notes")
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    imageVector = Icons.Rounded.Call,
                    contentDescription = null
                )
            },
        )
    }
}