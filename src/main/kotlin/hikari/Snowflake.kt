package hikari

import java.time.Instant

class Snowflake(private var snowflake: Long) {
    constructor(snowflake: String) : this(snowflake.toLong())

    fun toLong(): Long {
        return snowflake
    }

    fun toInstant(): Instant {
        return Instant.ofEpochMilli((snowflake shr 22) + Constants.discordEpoch)
    }

    fun getWorkerId(): Long {
        return (snowflake and 0x3E0000) shr 17
    }

    fun getProcessId(): Long {
        return (snowflake and 0x1F000) shr 12
    }

    fun getIncrement(): Long {
        return snowflake and 0xFFF
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Snowflake) return false
        if (this.snowflake != other.snowflake) return false

        return true
    }

    override fun toString(): String {
        return "Snowflake($snowflake, workerId=${this.getWorkerId()}, processId=${this.getProcessId()}, " +
                "increment=${this.getIncrement()}, instant=${this.toInstant()})"
    }

    override fun hashCode(): Int = snowflake.hashCode()
}