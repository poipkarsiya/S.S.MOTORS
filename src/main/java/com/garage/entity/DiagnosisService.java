
package com.garage.garagemanagementsystem.service;

import com.garage.garagemanagementsystem.entity.DiagnosisResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class DiagnosisService {

    public DiagnosisResult diagnose(
            String symptoms,
            String vehicleType,
            String fuelType) {

        List<String> causes = new ArrayList<>();
        List<String> actions = new ArrayList<>();

        String text = symptoms == null
                ? ""
                : symptoms.toLowerCase(Locale.ROOT);

        String fuel = fuelType == null
                ? ""
                : fuelType.toLowerCase(Locale.ROOT);

        String summary = "Preliminary symptom assessment";
        String urgency = "MEDIUM";
        String safety = "Have a qualified mechanic confirm the cause before replacing parts.";

        if (text.isBlank()) {
            return new DiagnosisResult(
                    "Please enter the vehicle symptoms.",
                    "LOW",
                    List.of("No symptoms provided"),
                    List.of("Describe the problem, when it occurs, and any warning lights."),
                    "No diagnosis can be suggested until symptoms are entered."
            );
        }

        if (containsAny(text, "brake failure", "brakes not working",
                "brake pedal goes to floor", "brake fluid leak")) {

            summary = "Possible brake system fault";
            urgency = "CRITICAL";
            causes.add("Low brake fluid or a hydraulic leak");
            causes.add("Brake component failure");
            causes.add("Air in the brake hydraulic system");
            actions.add("Inspect the brake fluid level and check for leaks.");
            actions.add("Have the brake system inspected by a qualified mechanic.");
            safety = "Do not drive the vehicle. Arrange safe recovery or towing.";
        }

        else if (containsAny(text, "engine overheating", "overheating",
                "temperature warning", "engine temperature high")) {

            summary = "Possible engine cooling system problem";
            urgency = "HIGH";
            causes.add("Low coolant or a coolant leak");
            causes.add("Cooling fan or thermostat fault");
            causes.add("Radiator restriction or water pump problem");
            actions.add("Stop safely and switch off the engine.");
            actions.add("Allow the engine to cool before any inspection.");
            actions.add("Have the cooling system and coolant leaks checked.");
            safety = "Do not open a hot radiator or coolant reservoir. Do not continue driving an overheating vehicle.";
        }

        else if (containsAny(text, "smoke", "burning smell", "burning odour",
                "burning odor")) {

            summary = "Possible overheating, electrical, or fluid-related fault";
            urgency = "HIGH";
            causes.add("Oil or another fluid contacting hot engine parts");
            causes.add("Electrical wiring or insulation fault");
            causes.add("Engine or clutch overheating");
            actions.add("Stop in a safe place and switch off the engine.");
            actions.add("Ask a mechanic to inspect for fluid leaks and electrical damage.");
            safety = "If smoke is heavy or there is a fire risk, move away from the vehicle and call emergency services.";
        }

        else if (containsAny(text, "engine won't start", "engine wont start",
                "not starting", "does not start", "won't start",
                "wont start", "starting problem")) {

            summary = "Possible starting system fault";
            urgency = "MEDIUM";
            causes.add("Weak battery or poor battery connections");
            causes.add("Starter motor or starter circuit fault");
            causes.add("Fuel delivery or ignition problem");
            actions.add("Check battery condition and terminal connections.");
            actions.add("Check whether the starter turns the engine.");
            actions.add("If the fault persists, test the starting and fuel systems.");
        }

        else if (containsAny(text, "battery", "dim lights",
                "slow cranking", "clicking sound when starting")) {

            summary = "Possible battery or charging system problem";
            urgency = "MEDIUM";
            causes.add("Weak or discharged battery");
            causes.add("Loose or corroded battery terminals");
            causes.add("Alternator or charging system fault");
            actions.add("Test battery voltage and condition.");
            actions.add("Inspect battery terminals and connections.");
            actions.add("Test the charging system if the battery repeatedly discharges.");
        }

        else if (containsAny(text, "engine noise", "knocking",
                "metallic sound", "rattling engine")) {

            summary = "Possible engine or moving-component noise";
            urgency = "HIGH";
            causes.add("Low engine oil or inadequate lubrication");
            causes.add("Loose or worn engine components");
            causes.add("Internal engine wear");
            actions.add("Check the engine oil level when safe and according to the manual.");
            actions.add("Arrange a mechanical inspection to identify the noise.");
            safety = "If the knocking is loud, sudden, or accompanied by an oil warning light, stop the engine and do not continue driving.";
        }

        else if (containsAny(text, "vibration", "steering shake",
                "steering wheel shaking", "vehicle shaking")) {

            summary = "Possible wheel, tyre, steering, or suspension problem";
            urgency = "MEDIUM";
            causes.add("Wheel imbalance or tyre damage");
            causes.add("Loose wheel fasteners");
            causes.add("Worn steering or suspension components");
            actions.add("Inspect tyres for visible damage.");
            actions.add("Have wheel fasteners, balancing, steering, and suspension checked.");
            safety = "If vibration is severe or steering control is affected, stop safely and arrange inspection.";
        }

        else if (containsAny(text, "poor mileage", "low mileage",
                "high fuel consumption", "using too much fuel",
                "fuel consumption")) {

            summary = "Possible fuel economy problem";
            urgency = "LOW";
            causes.add("Incorrect tyre pressure or driving conditions");
            causes.add("Air filter, spark plug, or fuel system issue");
            causes.add("Engine sensor or tuning problem");
            actions.add("Check tyre pressures against the vehicle manual.");
            actions.add("Inspect service history, air filter, and ignition components where applicable.");
            actions.add("Check for warning lights and scan fault codes if available.");
        }

        else if (containsAny(text, "brake noise", "squeaking brakes",
                "squealing brakes", "grinding when braking")) {

            summary = "Possible brake wear or brake component problem";
            urgency = "HIGH";
            causes.add("Worn brake pads or shoes");
            causes.add("Dust, contamination, or damaged brake components");
            causes.add("Brake disc or drum wear");
            actions.add("Arrange prompt inspection of pads, shoes, discs, or drums.");
            actions.add("Check for abnormal brake heat, leaks, or reduced braking performance.");
            safety = "If braking is reduced or a grinding noise is severe, do not drive the vehicle.";
        }

        else if (containsAny(text, "clutch slipping", "gear shifting",
                "difficulty changing gears", "gears not engaging")) {

            summary = "Possible clutch or transmission problem";
            urgency = "MEDIUM";
            causes.add("Clutch wear or adjustment issue");
            causes.add("Transmission linkage or fluid problem");
            causes.add("Internal transmission fault");
            actions.add("Record when the problem occurs and whether the engine revs increase without acceleration.");
            actions.add("Have the clutch and transmission inspected.");
        }

        else if (containsAny(text, "electric", "wiring", "fuse",
                "headlight not working", "indicator not working")) {

            summary = "Possible electrical system fault";
            urgency = "MEDIUM";
            causes.add("Blown fuse or faulty bulb");
            causes.add("Loose connection or damaged wiring");
            causes.add("Switch, relay, or charging system fault");
            actions.add("Check the relevant fuse using the vehicle manual.");
            actions.add("Inspect visible wiring and connections for damage.");
            actions.add("Have damaged wiring tested and repaired properly.");
        }

        else if (containsAny(text, "leak", "oil leaking",
                "coolant leaking", "fluid under vehicle")) {

            summary = "Possible fluid leak";
            urgency = "MEDIUM";
            causes.add("Engine oil, coolant, brake fluid, or another fluid leak");
            causes.add("Worn seal, hose, gasket, or loose connection");
            actions.add("Identify the fluid without touching hot or hazardous components.");
            actions.add("Arrange an inspection to locate and repair the leak.");
            safety = "If the leak may be brake fluid, fuel, or a large coolant/oil leak, do not drive until assessed.";
        }

        else {
            summary = "General vehicle symptom assessment";
            urgency = "MEDIUM";
            causes.add("The symptom may have several mechanical or electrical causes.");
            causes.add("More information is needed to narrow down the likely fault.");
            actions.add("Record when the symptom occurs, such as during starting, idling, braking, or acceleration.");
            actions.add("Check for dashboard warning lights and recent changes in vehicle performance.");
            actions.add("Arrange a mechanic inspection and diagnostic scan if available.");
        }

        if (fuel.contains("electric") && containsAny(text, "not starting",
                "won't start", "wont start", "starting problem")) {
            actions.add("For an electric vehicle, have the high-voltage and low-voltage systems checked by a qualified technician.");
        }

        if (vehicleType != null && !vehicleType.isBlank()) {
            summary += " (" + vehicleType.trim() + ")";
        }

        return new DiagnosisResult(
                summary,
                urgency,
                causes,
                actions,
                safety
        );
    }

    private boolean containsAny(String text, String... keywords) {
        for (String keyword : keywords) {
            if (text.contains(keyword)) {
                return true;
            }
        }
        return false;
    }
}
