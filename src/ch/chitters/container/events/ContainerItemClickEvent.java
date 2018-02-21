package ch.chitters.container.events;

public class ContainerItemClickEvent {
	protected boolean cancelled = true;

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
}
