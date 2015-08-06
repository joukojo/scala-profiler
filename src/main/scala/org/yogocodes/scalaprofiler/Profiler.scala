package org.yogocodes.scalaprofiler

import System.currentTimeMillis
import play.api.Logger

/**
 * @author joukojo
 */
object Profiler {

  def profile[R](code: => R, t: Long = currentTimeMillis): R = {

    val result = code

    val delta = currentTimeMillis - t
    val msg = "Elapsed time of " + (delta) + " ms"

    logMessage(msg, delta)
    result
  }

  def logMessage(message: String, delta: Long) = {
    if (delta >= 5000L) {
      Logger.error(message)
    } else if (delta >= 1000L) {
      Logger.warn(message)
    } else {
      Logger.trace(message)
    }

  }

  def profileWithIdentifier[R](identifier: String, code: => R, t: Long = currentTimeMillis): R = {
    val result = code

    val delta = currentTimeMillis - t
    val msg = "Elapsed time of (" + identifier + ") took " + (delta) + " ms"
    logMessage(msg, delta)
    
    result
  }

}