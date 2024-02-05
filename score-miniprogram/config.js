module.exports = {
	"origin": "https://test.miniprogram.com",
	"entry": "/",
	"router": {
		"result": [
			{
				"regexp": "^\\/result(?:\\/)?$",
				"options": "i"
			}
		],
		"getDetail": [
			{
				"regexp": "^\\/(?:\\/)?$",
				"options": "i"
			},
			{
				"regexp": "^\\/getDetail(?:\\/)?$",
				"options": "i"
			}
		],
		"signUp": [
			{
				"regexp": "^\\/signUp(?:\\/)?$",
				"options": "i"
			}
		]
	},
	"generate": {
		"worker": "common/workers"
	},
	"runtime": {
		"subpackagesMap": {},
		"tabBarMap": {},
		"usingComponents": {
			"TlbsmButton": {
				"path": "button/button",
				"props": [
					"size",
					"disabled"
				],
				"events": [
					"click"
				],
				"propsVal": {
					"size": null,
					"disabled": null
				}
			},
			"TlbsmNavbar": {
				"path": "navbar/navbar",
				"props": [
					"title",
					"titleMaxLength",
					"leftArrow",
					"delta"
				],
				"events": [
					"go-back"
				],
				"propsVal": {
					"title": null,
					"titleMaxLength": null,
					"leftArrow": null,
					"delta": null
				}
			},
			"TlbsmInput": {
				"path": "input/input",
				"props": [
					"value",
					"align",
					"size",
					"autocomplete",
					"autofocus",
					"clearable",
					"disabled",
					"readonly",
					"required",
					"errorMessage",
					"label",
					"maxlength",
					"name",
					"type",
					"placeholder"
				],
				"events": [
					"blur",
					"change",
					"clear",
					"focus"
				],
				"propsVal": {
					"value": null,
					"align": null,
					"size": null,
					"autocomplete": null,
					"autofocus": null,
					"clearable": null,
					"disabled": null,
					"readonly": null,
					"required": null,
					"errorMessage": null,
					"label": null,
					"maxlength": null,
					"name": null,
					"type": null,
					"placeholder": null
				}
			},
			"TlbsmRadio": {
				"path": "radio-group/radio-group",
				"props": [
					"value",
					"options"
				],
				"events": [
					"change"
				],
				"propsVal": {
					"value": null,
					"options": null
				}
			},
			"TlbsmDropdownMenu": {
				"path": "dropdown-menu/dropdown-menu",
				"props": [
					"activeColor",
					"closeOnClickOverlay",
					"duration",
					"zIndex"
				],
				"propsVal": {
					"activeColor": null,
					"closeOnClickOverlay": null,
					"duration": null,
					"zIndex": null
				}
			},
			"TlbsmDropdownItem": {
				"path": "dropdown-item/dropdown-item",
				"props": [
					"label",
					"disabled",
					"multiple",
					"options",
					"value"
				],
				"events": [
					"change"
				],
				"propsVal": {
					"label": null,
					"disabled": null,
					"multiple": null,
					"options": null,
					"value": null
				}
			}
		}
	},
	"pages": {
		"result": {
			"share": true,
			"shareTimeline": true,
			"windowScroll": false,
			"backgroundColor": "#fff",
			"rem": false,
			"extra": {
				"navigationBarTitleText": "result",
				"navigationStyle": "custom"
			}
		},
		"getDetail": {
			"share": true,
			"shareTimeline": true,
			"windowScroll": false,
			"backgroundColor": "#fff",
			"rem": false,
			"extra": {
				"navigationBarTitleText": "getDetail",
				"navigationStyle": "custom"
			}
		},
		"signUp": {
			"share": true,
			"shareTimeline": true,
			"windowScroll": false,
			"backgroundColor": "#fff",
			"rem": false,
			"extra": {
				"navigationBarTitleText": "application",
				"navigationStyle": "custom"
			}
		}
	},
	"redirect": {
		"notFound": "getDetail",
		"accessDenied": "getDetail"
	},
	"optimization": {
		"domSubTreeLevel": 10,
		"elementMultiplexing": true,
		"textMultiplexing": true,
		"commentMultiplexing": true,
		"domExtendMultiplexing": true,
		"styleValueReduce": 5000,
		"attrValueReduce": 5000
	}
}