package debcomp.com.aql.clusters42sp.models

import com.google.gson.annotations.SerializedName


/*
 * Davi Áquila
 *
 * 15/02/2020
 *
 */

class Coalition (

    @SerializedName(value = "name") var name: String
) {

    constructor() : this("")
}