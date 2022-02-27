package dev.mfazio.bgg.api.services

import dev.mfazio.bgg.api.model.remote.thing.poll.BGGThingPollResultsRemote
import org.simpleframework.xml.strategy.Type
import org.simpleframework.xml.strategy.Visitor
import org.simpleframework.xml.stream.InputNode
import org.simpleframework.xml.stream.NodeMap
import org.simpleframework.xml.stream.OutputNode

class BGGThingPollVisitor : Visitor {
    override fun read(type: Type?, node: NodeMap<InputNode>?) {
        if (type?.type == BGGThingPollResultsRemote::class.java) {
            node?.node?.let { element ->
                val className = when {
                    element.getAttribute("numplayers") != null -> "BGGThingPollNumberOfPlayersResultsRemote"
                    else -> "BGGThingPollBasicResultsRemote"
                }

                element.attributes.put("class", "$basePackage.$className")
            }
        }
    }

    override fun write(type: Type?, node: NodeMap<OutputNode>?) {
        // We're not using this here.
    }

    companion object {
        private const val basePackage = "dev.mfazio.bgg.api.model.remote.thing.poll"
    }
}