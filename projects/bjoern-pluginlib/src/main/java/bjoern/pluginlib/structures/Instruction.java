package bjoern.pluginlib.structures;

import bjoern.nodeStore.NodeTypes;
import bjoern.structures.BjoernNodeProperties;
import bjoern.structures.edges.EdgeTypes;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Vertex;
import octopus.lib.structures.OctopusNode;

public class Instruction extends OctopusNode implements Comparable<Instruction>
{

	public Instruction(Vertex vertex)
	{
		super(vertex, NodeTypes.INSTRUCTION);
	}

	public long getAddress()
	{
		return Long.parseLong(getProperty(BjoernNodeProperties.ADDR).toString());
	}

	public String getEsilCode()
	{
		return getProperty(BjoernNodeProperties.ESIL);
	}

	@Override
	public int compareTo(Instruction instruction)
	{
		if (this.getAddress() < instruction.getAddress())
		{
			return -1;
		} else if (this.getAddress() > instruction.getAddress())
		{
			return 1;
		} else
		{
			return 0;
		}
	}

	public String getCode()
	{
		return getProperty("repr");
	}

	public boolean isCall()
	{
		return getEdges(Direction.OUT, EdgeTypes.CALL).iterator().hasNext();
	}
}
