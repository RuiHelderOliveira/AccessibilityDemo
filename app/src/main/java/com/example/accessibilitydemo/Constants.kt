package com.example.accessibilitydemo

const val NAVIGATION = "Nav"
const val TRANSFER = "Transfer"
const val SHARE = "Share"

const val IBAN_STR = "iban_string"
const val NAME_STR = "name_string"

/**
 * Static object that defines the different deep-links
 */
object DeepLink {
    const val TRANSFER = "/transfer"
    const val SHARE = "/share"

    /**
     * Parameter types for the deep-links
     */
    object Params {
        const val ACTIVITY_TYPE = "option"
    }

    object Actions {
        const val ACTION_TOKEN_EXTRA = "actions.fulfillment.extra.ACTION_TOKEN"
    }
}
