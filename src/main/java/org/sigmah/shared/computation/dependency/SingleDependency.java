package org.sigmah.shared.computation.dependency;

import org.sigmah.shared.computation.instruction.Instructions;
import org.sigmah.shared.dto.element.FlexibleElementDTO;
import org.sigmah.shared.dto.element.TextAreaElementDTO;

/**
 * Dependency to a single flexible element existing in the same project as the
 * computation.
 * 
 * @author Raphaël Calabro (raphael.calabro@netapsys.fr)
 * @since 2.2
 */
public class SingleDependency implements Dependency {
	
	private FlexibleElementDTO flexibleElement;

	/**
	 * Empty constructor, required for serialization.
	 */
	public SingleDependency() {
		// Empty.
	}

	public SingleDependency(FlexibleElementDTO flexibleElement) {
		this.flexibleElement = flexibleElement;
	}

	public SingleDependency(int flexibleElementId) {
		final FlexibleElementDTO element = new TextAreaElementDTO();
		element.setId(flexibleElementId);
		this.flexibleElement = element;
	}

	public FlexibleElementDTO getFlexibleElement() {
		return flexibleElement;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isResolved() {
		return flexibleElement != null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int hash = 5;
		hash = 53 * hash + (flexibleElement != null ? flexibleElement.hashCode() : 0);
		return hash;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final SingleDependency other = (SingleDependency) obj;
		if (flexibleElement != null) {
			return flexibleElement.equals(other.flexibleElement);
		} else {
			return other.flexibleElement == null;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new StringBuilder()
                .append(Instructions.ID_PREFIX)
                .append(flexibleElement.getId())
                .toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toHumanReadableString() {
		return flexibleElement.getCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void accept(DependencyVisitor visitor) {
		visitor.visit(this);
	}
	
}
