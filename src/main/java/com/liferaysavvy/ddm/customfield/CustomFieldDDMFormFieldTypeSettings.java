/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferaysavvy.ddm.customfield;

import com.liferay.dynamic.data.mapping.annotations.*;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTypeSettings;
import com.liferay.dynamic.data.mapping.model.DDMFormFieldValidation;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.portal.kernel.util.StringPool;

/**
 * This TypeSettings class extends the default typesettings with custom DDM field attribute definitions.
 */
@DDMForm
@DDMFormLayout(
		paginationMode = com.liferay.dynamic.data.mapping.model.DDMFormLayout.TABBED_MODE,
		value = {
				@DDMFormLayoutPage(
						title = "%basic",
						value = {
								@DDMFormLayoutRow(
										{
												@DDMFormLayoutColumn(
														size = 12,
														value =
																{"label", "predefinedValue", "required", "tip"}
												)
										}
								)
						}
				),
				@DDMFormLayoutPage(
						title = "%properties",
						value = {
								@DDMFormLayoutRow(
										{
												@DDMFormLayoutColumn(
														size = 12,
														value = {
																"dataType", "name", "showLabel", "repeatable",
																"type", "validation", "visibilityExpression"
														}
												)
										}
								)
						}
				)
		}
)
public interface CustomFieldDDMFormFieldTypeSettings
		extends DDMFormFieldTypeSettings {

	@DDMFormField(visibilityExpression = "FALSE")
	public String fieldNamespace();

	@DDMFormField(
			label = "%indexable",
			optionLabels = {
					"%not-indexable", "%indexable-keyword", "%indexable-text"
			},
			optionValues = {StringPool.BLANK, "keyword", "text"},
			predefinedValue = "keyword", type = "radio",
			visibilityExpression = "FALSE"
	)
	public String indexType();

	@DDMFormField(
			label = "%label",
			properties = {
					"autoFocus=true", "placeholder=%enter-a-field-label",
					"tooltip=%enter-a-descriptive-field-label-that-guides-users-to-enter-the-information-you-want"
			},
			type = "key_value"
	)
	public LocalizedValue label();

	@DDMFormField(
			label = "%localizable", predefinedValue = "true",
			visibilityExpression = "FALSE"
	)
	public boolean localizable();

	@DDMFormField(
			label = "%predefined-value",
			properties = {
					"placeholder=%enter-a-default-value",
					"tooltip=%enter-a-default-value-that-is-submitted-if-no-other-value-is-entered"
			},
			type = "text"
	)
	public LocalizedValue predefinedValue();

	@DDMFormField(label = "%read-only", visibilityExpression = "FALSE")
	public boolean readOnly();

	@DDMFormField(label = "%repeatable", properties = "showAsSwitcher=true")
	public boolean repeatable();

	@DDMFormField(label = "%required-field", properties = "showAsSwitcher=true")
	public boolean required();

	@DDMFormField(
			label = "%show-label", predefinedValue = "true",
			properties = "showAsSwitcher=true"
	)
	public boolean showLabel();

	@DDMFormField(
			label = "%help-text",
			properties = {
					"placeholder=%enter-help-text",
					"tooltip=%add-a-comment-to-help-users-understand-the-field-label"
			},
			type = "text"
	)
	public LocalizedValue tip();

	@DDMFormField(
			dataType = "string", label = "%validation", type = "validation"
	)
	public DDMFormFieldValidation validation();

	/**
	 * @deprecated As of Judson (7.1.x)
	 */
	@DDMFormField(
			label = "%field-visibility-expression",
			properties = {
					"placeholder=%equals(Country, \"US\")",
					"tooltip=%write-a-conditional-expression-to-control-whether-this-field-is-displayed"
			},
			visibilityExpression = "FALSE"
	)
	@Deprecated
	public String visibilityExpression();

	////Add custom field settings attributes
	@DDMFormField(label = "%customCssClass")
	public String customCssClass();

	@DDMFormField(label = "%fieldWidth")
	public String fieldWidth();
	
	@DDMFormField(label = "%mobileNumberValidationMassage")
	public String mobileNumberValidationMassage();
	
	@DDMFormField(label = "%mobileNumberRegex")
	public String mobileNumberRegex();
	
}