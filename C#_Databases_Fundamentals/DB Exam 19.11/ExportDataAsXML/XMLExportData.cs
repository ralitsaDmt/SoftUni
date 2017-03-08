namespace ExportDataAsXML
{
    using System;
    using System.Linq;
    using System.Xml.Linq;
    using MassDefect.Data;

    public class XMLExportData
    {
        public static void Main(string[] args)
        {
            MassDefectContext context = new MassDefectContext();

            var exportAnomalies = context.Anomalies
                .Select(a => new
                {
                    id = a.Id,
                    originPlanet = new {name = a.OriginPlanet.Name},
                    teleportPlanet = new {name = a.TeleportPlanet.Name},
                    victims = a.Victims
                        .Select(v => new
                        {
                            name = v.Name.ToString()
                        })
                        .ToList()
                })
                .OrderBy(a => a.id);

            XElement xmlDoc = new XElement("anomalies");

            foreach (var exportedAnomaly in exportAnomalies)
            {
                var anomalyNode = new XElement("anomaly");

                anomalyNode.Add(new XAttribute("id", exportedAnomaly.id));
                anomalyNode.Add(new XAttribute("origin-planet", exportedAnomaly.originPlanet.name));
                anomalyNode.Add(new XAttribute("teleport-planet", exportedAnomaly.teleportPlanet.name));

                var victimsNode = new XElement("victims");

                foreach (var victim in exportedAnomaly.victims)
                {
                    XElement victimNode = new XElement("victim");
                    victimNode.Add(new XAttribute("name", victim.name));
                    victimsNode.Add(victimNode);
                }

                anomalyNode.Add(victimsNode);

                xmlDoc.Add(anomalyNode);
            }

            xmlDoc.Save("../../../results/anomalies.xml");
        }
    }
}
