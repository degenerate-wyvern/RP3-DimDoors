package org.dimdev.dimdoors.api.event

/** What caused a rift to open or close. */
enum class RiftChangeReason {
    /** A player toggled a dimensional door or trapdoor. */
    DOOR_TOGGLE,

    /** A detached rift shrank to nothing. */
    DECAY
}
